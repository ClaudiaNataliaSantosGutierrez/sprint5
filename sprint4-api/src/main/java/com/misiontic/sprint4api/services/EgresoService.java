package com.misiontic.sprint4api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.sprint4api.entity.Egreso;
import com.misiontic.sprint4api.repository.EgresoRepository;
import com.misiontic.sprint4api.validators.EgresoValidator;


@Service
public class EgresoService {

	@Autowired
	private EgresoRepository egresoRepo;
	
	
	public Egreso findById (Long egresoId) {
		Egreso egreso  = egresoRepo.findById(egresoId)
				.orElseThrow(() -> new RuntimeException("No existe el egreso."));
		return egreso;
	}
	
	
	@Transactional
	public void delete(Long egresoId) {
		Egreso egreso  = egresoRepo.findById(egresoId)
				.orElseThrow(() -> new RuntimeException("No existe el egreso."));
		egresoRepo.delete(egreso);
				
}
	
	
	
	public List<Egreso> findAll(){
		List<Egreso> egresos = egresoRepo.findAll();
		return egresos;
	}
	
	
	@Transactional
	public Egreso save(Egreso egreso) {
		
		EgresoValidator.save(egreso);
		
		if (egreso.getId()==null) {
			Egreso nuevoEgreso = egresoRepo.save(egreso);
			return nuevoEgreso;
		}
		Egreso existeEgreso = egresoRepo.findById(egreso.getId())
				.orElseThrow(() -> new RuntimeException("No existe el egreso."));
		existeEgreso.setTipoEgreso(egreso.getTipoEgreso());
		egresoRepo.save(existeEgreso);
		return existeEgreso;
	}
	
	
}
