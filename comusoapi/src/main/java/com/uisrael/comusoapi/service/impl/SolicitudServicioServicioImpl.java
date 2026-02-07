package com.uisrael.comusoapi.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.comusoapi.modelo.dto.request.SolicitudServicioRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.EquipoResponseDTO;
import com.uisrael.comusoapi.modelo.dto.response.SolicitudServicioResponseDTO;
import com.uisrael.comusoapi.service.IEquipoServicio;
import com.uisrael.comusoapi.service.ISolicitudServicioServicio;

@Service
public class SolicitudServicioServicioImpl implements ISolicitudServicioServicio {

    private final WebClient webClient;
    private final IEquipoServicio servicioEquipo;


    public SolicitudServicioServicioImpl(
            WebClient webClient,
            IEquipoServicio servicioEquipo) {
        this.webClient = webClient;
        this.servicioEquipo = servicioEquipo;
    }

    @Override
    public String agendar(int idEquipo, String fecha, String hora, String modalidad) {
        // 1️⃣ Validación del ID del equipo
        if (idEquipo <= 0) {
            throw new IllegalArgumentException("El ID del equipo es inválido: " + idEquipo);
        }

        // 2️⃣ Obtener el equipo usando el servicio
        EquipoResponseDTO equipo = servicioEquipo.buscarEquipoPorId(idEquipo);
        int idClienteCalculado = equipo.getIdcliente();

        // 3️⃣ Crear el DTO de solicitud
        SolicitudServicioRequestDTO dto = new SolicitudServicioRequestDTO();
        dto.setIdequipo(idEquipo);
        dto.setIdcliente(idClienteCalculado);

        // 4️⃣ Generar el ticket
        String token = "TKT-" + java.util.UUID.randomUUID()
                .toString().substring(0, 5).toUpperCase();
        dto.setCodigoticket(token);
        dto.setFechacita(java.time.LocalDate.parse(fecha));
        dto.setHoracita(java.time.LocalTime.parse(hora));
        dto.setModalidadatencion(modalidad);
        dto.setEstado("PENDIENTE");

        // 5️⃣ Enviar la solicitud al API
        webClient.post()
                .uri("/api/solicitud")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(Void.class)
                .block();

        return token;
    }

    @Override
    public List<SolicitudServicioResponseDTO> listarTodas() {
        return webClient.get()
                .uri("/api/solicitud")
                .retrieve()
                .bodyToFlux(SolicitudServicioResponseDTO.class)
                .collectList()
                .block();
    }
}
