package com.misiontic.sprint4api.IngresoDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EgresoDTO {
	
	private Long id;
	private String tipoEgreso;
	private Float valorEgreso;

}
