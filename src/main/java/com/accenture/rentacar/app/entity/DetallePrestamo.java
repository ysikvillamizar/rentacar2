package com.accenture.rentacar.app.entity;

import java.io.Serializable;
import java.time.DateTimeException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.accenture.rentacar.app.util.utilDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="detalle_prestamo")
public class DetallePrestamo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//usar siempre esta variable con serializable,para que la implemantacion de la clase sea mas eficiente
	
	@Id
	//private MiClase miClase// otra clase que contruya con varios primarykey
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="vehiculo_id")//cuando contruya tabla detalleprestamo va contruir columna vehiculo id, va a ser clave foranea
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})//para formar el json
	private Vehiculo vehiculo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_prestamo")
	private Date fechaInicioPrestamo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_prestamo")
	private Date fechaFinPrestamo;
	
	
	@Column(name="total_dias_prestamo")
	private int totalDiasPrestamo;

	//ejemplo
	@PrePersist
	public void calcularDias() throws DateTimeException {
		//double pi= utilDate.VALOR_PI;
		utilDate.calcularDias(fechaInicioPrestamo, fechaFinPrestamo);
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public Date getFechaInicioPrestamo() {
		return fechaInicioPrestamo;
	}


	public void setFechaInicioPrestamo(Date fechaInicioPrestamo) {
		this.fechaInicioPrestamo = fechaInicioPrestamo;
	}


	public Date getFechaFinPrestamo() {
		return fechaFinPrestamo;
	}


	public void setFechaFinPrestamo(Date fechaFinPrestamo) {
		this.fechaFinPrestamo = fechaFinPrestamo;
	}


	public int getTotalDiasPrestamo() {
		return totalDiasPrestamo;
	}


	public void setTotalDiasPrestamo(int totalDiasPrestamo) {
		this.totalDiasPrestamo = totalDiasPrestamo;
	}
	
	

}
