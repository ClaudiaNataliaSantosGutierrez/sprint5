package com.misiontic.sprint4api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.sprint4api.entity.Egreso;

@Repository
public interface EgresoRepository extends JpaRepository<Egreso, Long> {

}
