package com.cainco.bootcamp.system.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoRestController {

	@GetMapping
	public String hola() {
		return "Hola Mundo";
	}
}
