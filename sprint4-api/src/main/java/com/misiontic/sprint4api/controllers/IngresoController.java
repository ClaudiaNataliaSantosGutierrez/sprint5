package com.misiontic.sprint4api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.sprint4api.IngresoDTO.IngresoDTO;
import com.misiontic.sprint4api.entity.Ingreso;
import com.misiontic.sprint4api.services.IngresoService;

@RestController
public class IngresoController {

	@Autowired
	private IngresoService ingresoService;
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/ingresos/{ingresoId}")
	public ResponseEntity<IngresoDTO> findById(@PathVariable("ingresoId") Long ingresoId ) {
		Ingreso ingreso = ingresoService.findById(ingresoId);
		
		IngresoDTO ingresoDto = IngresoDTO.builder()
				.id(ingreso.getId())
				.tipoIngreso(ingreso.getTipoIngreso())
				.valorIngreso(ingreso.getValorIngreso())
				.build();
		
		return new ResponseEntity<IngresoDTO>(ingresoDto, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/ingresos/{ingresoId}")
	public ResponseEntity<Void> delete(@PathVariable("ingresoId") Long ingresoId) {
		ingresoService.delete(ingresoId);
		return new ResponseEntity <> (HttpStatus.OK);
		
}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/ingresos")
	public ResponseEntity<List<IngresoDTO>> findAll(){
		List<Ingreso> ingresos = ingresoService.findAll();
		
		List<IngresoDTO> ingresoDto = ingresos.stream().map(ingreso -> {
			return IngresoDTO.builder()
					.id(ingreso.getId())
					.tipoIngreso(ingreso.getTipoIngreso())
					.valorIngreso(ingreso.getValorIngreso())
					.build();
		})
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<IngresoDTO>>(ingresoDto, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/ingresos")
	public ResponseEntity<IngresoDTO> create(@RequestBody Ingreso ingreso) {
		Ingreso nuevoIngreso = ingresoService.save(ingreso);
		
		IngresoDTO ingresoDTO = IngresoDTO.builder()
				.id(nuevoIngreso.getId())
				.tipoIngreso(nuevoIngreso.getTipoIngreso())
				.valorIngreso(nuevoIngreso.getValorIngreso())
				.build();
		
		return new ResponseEntity<IngresoDTO>(ingresoDTO, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping(value = "/ingresos")
	public ResponseEntity<IngresoDTO> update(@RequestBody Ingreso ingreso) {
		Ingreso existeIngreso = ingresoService.save(ingreso);
		
		IngresoDTO ingresoDto = IngresoDTO.builder()
				.id(existeIngreso.getId())
				.tipoIngreso(existeIngreso.getTipoIngreso())
				.valorIngreso(existeIngreso.getValorIngreso())
				.build();
		
		return new ResponseEntity<IngresoDTO>(ingresoDto, HttpStatus.OK);
	}
}
