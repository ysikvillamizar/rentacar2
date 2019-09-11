package com.accenture.rentacar.app.util;

import java.time.format.DateTimeParseException;
import java.util.Date;

public class utilDate {

	public static final double VALOR_PI= 3.1416;
	
	public static int calcularDias(Date fechaInicio, Date fechaFinal) {
		
		try {
			long diferencia = fechaFinal.getTime() - fechaInicio.getTime(); //.getTime me devuelve la fecha en milisegundos
			Long d=(diferencia/(1000*60*60*24));
			int dias= d.intValue();
			//ej. cierro conexion
			return dias;
		}
		catch(DateTimeParseException e) {
			throw e;//lanzar la excepcion mostrarle a los otros la excepcion(hacia atras)
			//System.err.println(e);
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			
		}
		
		
	}
}
