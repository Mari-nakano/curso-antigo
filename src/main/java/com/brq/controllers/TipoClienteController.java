package com.brq.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.dtos.TipoClienteDTO;
import com.brq.services.TipoClienteService;


@RequestMapping("tipo-clientes")
@RestController
public class TipoClienteController {
	
	//nao ficar copiando as dependencias
	@Autowired
	private TipoClienteService tipoClienteService;
	
	@GetMapping("")
	public List<TipoClienteDTO> findAll() {
		
		return this.tipoClienteService.findAll();
		
	}
	
	@GetMapping("/{codtipocli}")
	public TipoClienteDTO findOne(@PathVariable String codtipocli) {
		return this.tipoClienteService.findOne(codtipocli);
	}
	
	@PostMapping("")
	public TipoClienteDTO save(@RequestBody TipoClienteDTO novoTipoCliente) {
		return this.tipoClienteService.save(novoTipoCliente);
		
		
	}
	
	@PatchMapping("/{codtipocli}")
	public TipoClienteDTO update(@PathVariable String codtipocli, @RequestBody TipoClienteDTO alterarTipoCliente ) {
		return this.tipoClienteService.update(codtipocli, alterarTipoCliente);
	}
	
	@DeleteMapping("/{codtipocli}")
	public void delete(@PathVariable String codtipocli) {
		this.tipoClienteService.delete(codtipocli);
	}
	
	

}
