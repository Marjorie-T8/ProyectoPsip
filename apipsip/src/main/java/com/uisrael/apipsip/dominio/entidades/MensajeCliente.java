package com.uisrael.apipsip.dominio.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensaje_cliente")
public class MensajeCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensaje")
    private Long idMensaje;

    @Column(name = "id_orden", nullable = false)
    private Integer idOrden;

    @Column(name = "tipo_mensaje", length = 20, nullable = false)
    private String tipoMensaje;

    @Column(name = "medio", length = 10, nullable = false)
    private String medio;

    @Column(name = "destinatario", length = 150, nullable = false)
    private String destinatario;

    @Column(name = "contenido", columnDefinition = "TEXT", nullable = false)
    private String contenido;

    @Column(name = "fecha_envio", nullable = false)
    private LocalDateTime fechaEnvio = LocalDateTime.now();

    @Column(name = "estado_envio", length = 15)
    private String estadoEnvio;

    public MensajeCliente() {}

    // Getters y setters mínimos
    public Long getIdMensaje() { return idMensaje; }
    public void setIdMensaje(Long idMensaje) { this.idMensaje = idMensaje; }

    public Integer getIdOrden() { return idOrden; }
    public void setIdOrden(Integer idOrden) { this.idOrden = idOrden; }

    public String getTipoMensaje() { return tipoMensaje; }
    public void setTipoMensaje(String tipoMensaje) { this.tipoMensaje = tipoMensaje; }

    public String getMedio() { return medio; }
    public void setMedio(String medio) { this.medio = medio; }
}