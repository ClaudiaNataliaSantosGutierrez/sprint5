package com.misiontic.sprint4api.IngresoDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class IngresoDTO {

    private Long id;
	private String tipoIngreso;
	private Float valorIngreso;
}
