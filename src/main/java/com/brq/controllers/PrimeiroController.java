package com.brq.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	
	@GetMapping("meu-primeiro-controller")
	public String minhaPrimeiraMensagem() {
		return "Mari";
	}
	
	@PostMapping("meu-primeiro-controller")
	public String minhaPrimeiraMensagemPost() {
		return "Mari1";
	}
	
	@GetMapping("segunda")
	public ArrayList<String> minhaSegundaMensagem(){
		ArrayList<String> AL = new ArrayList<>();
		
		AL.add("Qualquer coisa");
		
		return AL;
	}
	
}
