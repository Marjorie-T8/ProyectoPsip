package com.uisrael.apipsip.dominio.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "anexo_documento")
public class AnexoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anexo")
    private Long idAnexo;

    @Column(name = "id_orden", nullable = false)
    private Integer idOrden;

    @Column(name = "nombre_original", length = 255, nullable = false)
    private String nombreOriginal;

    @Column(name = "nombre_guardado", length = 255, nullable = false)
    private String nombreGuardado;

    @Column(name = "tipo_mime", length = 100)
    private String tipoMime;

    @Column(name = "tamanio_bytes")
    private Long tamanioBytes;

    @Column(name = "fecha_subida", nullable = false)
    private LocalDateTime fechaSubida = LocalDateTime.now();

    public AnexoDocumento() {}

    public Long getIdAnexo() { return idAnexo; }
    public void setIdAnexo(Long idAnexo) { this.idAnexo = idAnexo; }

    public Integer getIdOrden() { return idOrden; }
    public void setIdOrden(Integer idOrden) { this.idOrden = idOrden; }

    public String getNombreOriginal() { return nombreOriginal; }
    public void setNombreOriginal(String nombreOriginal) { this.nombreOriginal = nombreOriginal; }

    public String getNombreGuardado() { return nombreGuardado; }
    public void setNombreGuardado(String nombreGuardado) { this.nombreGuardado = nombreGuardado; }
}