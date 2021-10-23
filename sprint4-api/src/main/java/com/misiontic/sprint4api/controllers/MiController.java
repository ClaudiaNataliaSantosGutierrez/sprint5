package com.misiontic.sprint4api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiController {

	@GetMapping(value = "bienvenido")
	public String bienvenido() {
		return "Hola, bienvenido a SAFE-IN";
	}
}
