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
    public String agendar(int idEquipo, String fecha, String hora, String modalidad,
                          String direccion, String descripcion) {
        // 1. Obtener el equipo para sacar el ID del cliente
        EquipoResponseDTO equipo = servicioEquipo.buscarEquipoPorId(idEquipo);
        int idClienteCalculado = equipo.getIdcliente();

        // 2. Crear el DTO de solicitud
        SolicitudServicioRequestDTO dto = new SolicitudServicioRequestDTO();
        dto.setIdequipo(idEquipo);
        dto.setIdcliente(idClienteCalculado);
        dto.setModalidadatencion(modalidad);
        dto.setDireccionservicio(direccion);
        dto.setFechacita(java.time.LocalDate.parse(fecha));
        dto.setHoracita(java.time.LocalTime.parse(hora));
        dto.setEstado("PENDIENTE");

        // 3. Generar el ticket
        String token = "TKT-" + java.util.UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        dto.setCodigoticket(token);

        // 4. Imprimir el JSON que se envía (para debug - puedes quitar después)
        try {
            String json = new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(dto);
            System.out.println("JSON enviado al servidor: " + json);
        } catch (Exception e) {
            System.err.println("Error al imprimir JSON: " + e.getMessage());
        }

        // 5. Llamar al backend (ruta correcta)
        SolicitudServicioResponseDTO respuesta = webClient.post()
                .uri("/solicitud")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(SolicitudServicioResponseDTO.class)
                .block();

        // 6. Mostrar respuesta (opcional)
        System.out.println("Respuesta del servidor - Ticket: " + respuesta.getCodigoticket());
        System.out.println("Respuesta del servidor - ID: " + respuesta.getIdsolicitud());

        // Retornamos el token generado localmente (como en tu lógica original)
        return token;
    }

    @Override
    public List<SolicitudServicioResponseDTO> listarTodas() {
        return webClient.get()
                .uri("/solicitud")
                .retrieve()
                .bodyToFlux(SolicitudServicioResponseDTO.class)
                .collectList()
                .block();
    }
}

