package com.uisrael.apipsip.dominio.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.net.InetAddress;

@Entity
@Table(name = "pagina_web")
public class PaginaWeb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acceso")
    private Long idAcceso;

    @Column(name = "id_orden", nullable = false)
    private Integer idOrden;

    @Column(name = "ip_cliente")
    private String ipCliente; // En PostgreSQL es INET, pero en Java usamos String

    @Column(name = "user_agent", columnDefinition = "TEXT")
    private String userAgent;

    @Column(name = "fecha_acceso", nullable = false)
    private LocalDateTime fechaAcceso = LocalDateTime.now();

    @Column(name = "tipo_acceso", length = 30, nullable = false)
    private String tipoAcceso;

    public PaginaWeb() {}

    public Long getIdAcceso() { return idAcceso; }
    public void setIdAcceso(Long idAcceso) { this.idAcceso = idAcceso; }

    public Integer getIdOrden() { return idOrden; }
    public void setIdOrden(Integer idOrden) { this.idOrden = idOrden; }

    public String getIpCliente() { return ipCliente; }
    public void setIpCliente(String ipCliente) { this.ipCliente = ipCliente; }

    public String getUserAgent() { return userAgent; }
    public void setUserAgent(String userAgent) { this.userAgent = userAgent; }

    public String getTipoAcceso() { return tipoAcceso; }
    public void setTipoAcceso(String tipoAcceso) { this.tipoAcceso = tipoAcceso; }
}