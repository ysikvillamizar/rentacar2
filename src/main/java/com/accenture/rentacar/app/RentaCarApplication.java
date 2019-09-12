package com.accenture.rentacar.app;
import java.util.Date;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.accenture.uilidades.fechas.Fecha;

@SpringBootApplication
public class RentaCarApplication {

	public static void main(String[] args) {
		//SpringApplication.run(RentaCarApplication.class, args);//esta linea inicia o arranca nuestro proyecto
		//click derecho run as java application
		
		System.out.println("Resultado: " + Fecha.calcularDias(new Date("12/05/2018"), null));//mi error exception
		//System.out.println("Resultado: " + Fecha.calcularDias(new Date("12/05/2018"), new Date()));
	        
	      
	}

}
