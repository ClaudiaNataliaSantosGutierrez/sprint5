package com.misiontic.sprint4api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.sprint4api.IngresoDTO.EgresoDTO;
import com.misiontic.sprint4api.entity.Egreso;
import com.misiontic.sprint4api.services.EgresoService;

@RestController
public class EgresoControlller {

	@Autowired
	private EgresoService egresoService;
	
	
	@GetMapping(value = "/egresos/{egresoId}")
	public ResponseEntity<EgresoDTO> findById(@PathVariable("egresoId") Long egresoId ) {
		Egreso egreso = egresoService.findById(egresoId);
		
		EgresoDTO egresoDto = EgresoDTO.builder()
				.id(egreso.getId())
				.tipoEgreso(egreso.getTipoEgreso())
				.valorEgreso(egreso.getValorEgreso())
				.build();
		
		return new ResponseEntity<EgresoDTO>(egresoDto, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/egresos/{egresoId}")
	public ResponseEntity<Void> delete(@PathVariable("egresoId") Long egresoId) {
		egresoService.delete(egresoId);
		return new ResponseEntity <> (HttpStatus.OK);
		
}
	
	
	@GetMapping(value = "/egresos")
	public ResponseEntity<List<EgresoDTO>> findAll(){
		List<Egreso> egresos = egresoService.findAll();
		
		List<EgresoDTO> egresoDto = egresos.stream().map(egreso -> {
			return EgresoDTO.builder()
					.id(egreso.getId())
					.tipoEgreso(egreso.getTipoEgreso())
					.valorEgreso(egreso.getValorEgreso())
					.build();
		})
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<EgresoDTO>>(egresoDto, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/egresos")
	public ResponseEntity<EgresoDTO> create(@RequestBody Egreso egreso) {
		Egreso nuevoEgreso = egresoService.save(egreso);
		
		EgresoDTO egresoDTO = EgresoDTO.builder()
				.id(nuevoEgreso.getId())
				.tipoEgreso(nuevoEgreso.getTipoEgreso())
				.valorEgreso(nuevoEgreso.getValorEgreso())
				.build();
		
		return new ResponseEntity<EgresoDTO>(egresoDTO, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/egresos")
	public ResponseEntity<EgresoDTO> update(@RequestBody Egreso egreso) {
		Egreso existeEgreso = egresoService.save(egreso);
		
		EgresoDTO egresoDto = EgresoDTO.builder()
				.id(existeEgreso.getId())
				.tipoEgreso(existeEgreso.getTipoEgreso())
				.valorEgreso(existeEgreso.getValorEgreso())
				.build();
		
		return new ResponseEntity<EgresoDTO>(egresoDto, HttpStatus.OK);
	}
}
