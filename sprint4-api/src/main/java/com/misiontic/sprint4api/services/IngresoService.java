package com.misiontic.sprint4api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.sprint4api.entity.Ingreso;
import com.misiontic.sprint4api.repository.IngresoRepository;
import com.misiontic.sprint4api.validators.IngresoValidator;


@Service
public class IngresoService {

	@Autowired
	private IngresoRepository ingresoRepo;
	
	
	public Ingreso findById (Long ingresoId) {
		Ingreso ingreso  = ingresoRepo.findById(ingresoId)
				.orElseThrow(() -> new RuntimeException("No existe el ingreso."));
		return ingreso;
	}
	
	
	@Transactional
	public void delete(Long ingresoId) {
		Ingreso ingreso  = ingresoRepo.findById(ingresoId)
				.orElseThrow(() -> new RuntimeException("No existe el ingreso."));
		ingresoRepo.delete(ingreso);
				
}
	
	
	
	public List<Ingreso> findAll(){
		List<Ingreso> ingresos = ingresoRepo.findAll();
		return ingresos;
	}
	
	
	@Transactional
	public Ingreso save(Ingreso ingreso) {
		
		IngresoValidator.save(ingreso);
		
		if (ingreso.getId()==null) {
			Ingreso nuevoIngreso = ingresoRepo.save(ingreso);
			return nuevoIngreso;
		}
		Ingreso existeIngreso = ingresoRepo.findById(ingreso.getId())
				.orElseThrow(() -> new RuntimeException("No existe el ingreso."));
		existeIngreso.setTipoIngreso(ingreso.getTipoIngreso());
		ingresoRepo.save(existeIngreso);
		return existeIngreso;
	}
	
}
