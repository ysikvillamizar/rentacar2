package com.accenture.rentacar.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Vehiculos")//con esta notacion aseguro que la tabla era en minusculay plurarl
public class Vehiculo {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//generar
	private Long id;
	
	
	@Column(name="modelo_auto")
	private short modeloAuto;
	private String marca;
	private String placa;
	private String linea;
	private String color;
	
	/*public Vehiculo(String marca) {
		this.marca= marca;
	}
	
	public Vehiculo(short modeloAuto) {
		this.modeloAuto=modeloAuto;
	}
	*/
	
	
	@Column(name="fecha_creacion_registro")
	@Temporal( TemporalType.DATE)//parceo de java a sql
	private Date fechaCreacionRegistro;
	
	
	@PrePersist//antes de guardar el registro le asigne el valor a la variable y la fecha actual pase 
	private void preGuardado() {
		fechaCreacionRegistro= new Date();
	}
	
	
	
	public Date getFechaCreacionRegistro() {
		return fechaCreacionRegistro;
	}



	public void setFechaCreacionRegistro(Date fechaCreacionRegistro) {
		this.fechaCreacionRegistro = fechaCreacionRegistro;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public short getModeloAuto() {
		return modeloAuto;
	}
	public void setModelo(short modelo) {
		this.modeloAuto = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
	
	
}
