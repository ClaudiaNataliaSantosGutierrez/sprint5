package com.misiontic.sprint4api.validators;

import com.misiontic.sprint4api.entity.Ingreso;

public class IngresoValidator {

	public static void save (Ingreso ingreso) {
		if (ingreso.getTipoIngreso()==null  || ingreso.getTipoIngreso().trim().isEmpty()) {
			throw new RuntimeException("El tipo de ingreso es obligatorio");
		}
		if (ingreso.getTipoIngreso().length() > 100) {
			throw new RuntimeException("El tipo de ingreso no puede ser mayor a 100 caracteres");
		}
	}
}
