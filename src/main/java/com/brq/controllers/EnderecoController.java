package com.brq.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brq.dtos.EnderecoDTO;
import com.brq.services.EnderecoService;

@RequestMapping("endereco")
@RestController
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("")
	private ResponseEntity<List<EnderecoDTO>> findAll() {
		return ResponseEntity.ok().body(this.enderecoService.findAll());
	}
	
	
	@GetMapping("/{id}")
	private ResponseEntity<EnderecoDTO> findOne(@PathVariable int id) {
		return ResponseEntity.ok().body(this.enderecoService.findOne(id));
	}
	
//	@GetMapping("/end-por-logradouro/{logradouro}")
//	private ResponseEntity<List<EnderecoDTO>> findByLogradouro(@PathVariable String logradouro) {
//		return ResponseEntity.ok().body(this.enderecoService.findByLogradouro(logradouro));	
//	}
//	
	
	
	@PostMapping("")
	private ResponseEntity<EnderecoDTO> save(@Valid @RequestBody EnderecoDTO endereco) {
		return ResponseEntity.ok().body(this.enderecoService.save(endereco));
		}
	
	
	@PatchMapping("/{id}")
	private ResponseEntity<EnderecoDTO> update(@Valid @RequestBody EnderecoDTO novoEndereco, @PathVariable int id) {
		return ResponseEntity.ok().body(this.enderecoService.update(novoEndereco, id));
	}
	
	
	@DeleteMapping("/{id}")
	private void delete(int id) {
		this.enderecoService.delete(id);
	}
	
	@GetMapping("paginacao")
	public ResponseEntity<Page<EnderecoDTO>> paginacao(@RequestParam(name = "pagina", defaultValue = "0") int pagina,
						 @RequestParam(name = "registros", defaultValue = "10") int registros) {
		
		return  ResponseEntity.ok().body(this.enderecoService.paginacao(pagina, registros));
		
	}
	

}
