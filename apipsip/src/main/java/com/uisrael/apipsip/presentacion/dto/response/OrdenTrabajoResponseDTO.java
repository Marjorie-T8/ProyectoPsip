package com.uisrael.apipsip.presentacion.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

import com.uisrael.apipsip.dominio.entidades.Cliente;
import com.uisrael.apipsip.dominio.entidades.Equipo;
import com.uisrael.apipsip.dominio.entidades.Tecnico;
import com.uisrael.apipsip.dominio.entidades.TipoServicio;

public class OrdenTrabajoResponseDTO {
	
		private  int idOrden;
		private  String codigo;
		private  Cliente cliente;
		private Tecnico tecnico;
		private  TipoServicio tipoServicio;
		private  Equipo equipo;
		private  LocalDate fechaSolicitud;
		private  LocalDate fechaAgendada;
		private LocalTime horaAgendada;
		private  String estado;
		private  String descripcionTrabajo;
		private  String observaciones;
		public int getIdOrden() {
			return idOrden;
		}
		public void setIdOrden(int idOrden) {
			this.idOrden = idOrden;
		}
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public Cliente getCliente() {
			return cliente;
		}
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		public Tecnico getTecnico() {
			return tecnico;
		}
		public void setTecnico(Tecnico tecnico) {
			this.tecnico = tecnico;
		}
		public TipoServicio getTipoServicio() {
			return tipoServicio;
		}
		public void setTipoServicio(TipoServicio tipoServicio) {
			this.tipoServicio = tipoServicio;
		}
		public Equipo getEquipo() {
			return equipo;
		}
		public void setEquipo(Equipo equipo) {
			this.equipo = equipo;
		}
		public LocalDate getFechaSolicitud() {
			return fechaSolicitud;
		}
		public void setFechaSolicitud(LocalDate fechaSolicitud) {
			this.fechaSolicitud = fechaSolicitud;
		}
		public LocalDate getFechaAgendada() {
			return fechaAgendada;
		}
		public void setFechaAgendada(LocalDate fechaAgendada) {
			this.fechaAgendada = fechaAgendada;
		}
		public LocalTime getHoraAgendada() {
			return horaAgendada;
		}
		public void setHoraAgendada(LocalTime horaAgendada) {
			this.horaAgendada = horaAgendada;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public String getDescripcionTrabajo() {
			return descripcionTrabajo;
		}
		public void setDescripcionTrabajo(String descripcionTrabajo) {
			this.descripcionTrabajo = descripcionTrabajo;
		}
		public String getObservaciones() {
			return observaciones;
		}
		public void setObservaciones(String observaciones) {
			this.observaciones = observaciones;
		}


}
