package com.accenture.rentacar.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.rentacar.app.entity.Vehiculo;
import com.accenture.rentacar.app.service.IVehiculoService;

@RestController
@RequestMapping("/api")
public class VehiculoController {

	@Autowired
	private IVehiculoService vehiculoService;
	
	@GetMapping("/vehiculos")
	public List<Vehiculo> listar(){
		return vehiculoService.listarTodos(); 
	}
	
	@GetMapping("/vehiculos/{id}")
	public Vehiculo buscarPorId(@PathVariable Long id ) {
		return vehiculoService.buscarVehiculoPorId(id);
	}
	
	@PostMapping("/vehiculos")
	public Vehiculo guardar (@RequestBody Vehiculo[] vehiculo) {//lo recibo en el body del request
		return vehiculoService.guardar(vehiculo.length);
	}
	
	
	@SuppressWarnings("unused")//para quitr el warning cuando tengo varianles sin usarla
	@PostMapping("/actualizar")
	public Vehiculo actualizar(@RequestBody Vehiculo vehiculo) {
		//Vehiculo vehiNuevo= new Vehiculo("TOYOTA");
		//Vehiculo vehiNuevoDos= new Vehiculo((short)2021);
		Vehiculo vehiAActualizar= new Vehiculo();
		Vehiculo vehiActual= vehiculoService.buscarVehiculoPorId(vehiculo.getId());
		vehiAActualizar.setId(vehiculo.getId());
		vehiAActualizar.setColor(vehiculo.getColor());
		vehiAActualizar.setLinea(vehiculo.getLinea());
		vehiAActualizar.setMarca(vehiculo.getMarca());
		vehiAActualizar.setModelo(vehiculo.getModeloAuto());
		vehiAActualizar.setPlaca(vehiculo.getPlaca());
		
		
		return vehiculoService.guardar(vehiAActualizar) ;
	}
	
	@DeleteMapping("/vehiculos/{id}")
	public String borrar(@PathVariable Long id) {
		vehiculoService.borrar(id);
		return "El vehiculo se elimino correctamente";
	}
	
	
}
