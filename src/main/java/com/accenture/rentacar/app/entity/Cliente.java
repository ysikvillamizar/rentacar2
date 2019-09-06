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
@Table(name="Clientes")//con esta notacion aseguro que la tabla era en minusculay plurarl
public class Cliente {
	
	

		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)//generear
		private Long id;
		
		
		
		private double cedula;
		private String nombre;
		private String apellido;
		private String telefono;
		private String direccion;
		private String email;
		
		/*		
		public Cliente(String nombre) {
		this.nombre= nombre;
	}
	
		public Cliente(String apellido) {
		this.apellido=apellido;
	}
	*/
	
		
		@Column(name="fecha_creacion_cliente")
		@Temporal( TemporalType.DATE)//parceo de java a sql
		private Date fechaCreacionCliente;
		
		
		@PrePersist//antes de guardar el registro le asigne el valor a la variable y la fecha actual pase 
		private void preGuardado() { //para darle valor a la fecha antes de que se ejecute	
			fechaCreacionCliente= new Date();
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		


		public double getCedula() {
			return cedula;
		}


		public void setCedula(double cedula) {
			this.cedula = cedula;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getApellido() {
			return apellido;
		}


		public void setApellido(String apellido) {
			this.apellido = apellido;
		}


		public String getTelefono() {
			return telefono;
		}


		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}


		public String getDireccion() {
			return direccion;
		}


		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public Date getFechaCreacionCliente() {
			return fechaCreacionCliente;
		}


		public void setFechaCreacionCliente(Date fechaCreacionCliente) {
			this.fechaCreacionCliente = fechaCreacionCliente;
		}
		
		
}
