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

import com.brq.dtos.EscolaDTO;
import com.brq.services.EscolaService;

@RequestMapping("escola")
@RestController
public class EscolaController {
	
	@Autowired
	private EscolaService escolaService;
	
	@GetMapping("")
	public ResponseEntity<List<EscolaDTO>> findAll() {
		return ResponseEntity.ok().body(this.escolaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EscolaDTO> findOne(@PathVariable int id) {
		return ResponseEntity.ok().body(this.escolaService.findOne(id));
	}
	
	@GetMapping("/escola-por-nome/{nome}")
	public ResponseEntity<List<EscolaDTO>> findByNome(@PathVariable String nome) {
		return ResponseEntity.ok().body(this.escolaService.findByNome(nome));
	}
	
	@PostMapping("")
	public ResponseEntity<EscolaDTO> save(@Valid @RequestBody EscolaDTO escola) {
		return ResponseEntity.ok().body(this.escolaService.save(escola));
	}
	
	
	@PatchMapping("/{id}")	
	public ResponseEntity<EscolaDTO> update(@PathVariable int id, @Valid @RequestBody EscolaDTO novaEscola) {
		
		return ResponseEntity.ok().body(this.escolaService.update(id, novaEscola));
		
	}
	
	@DeleteMapping("/{id}")
	
	public void delete(@PathVariable int id) {
		this.escolaService.delete(id);
		
	}
	
	@GetMapping("paginacao")
	public ResponseEntity< Page<EscolaDTO> > paginacao(@RequestParam(name = "pagina", defaultValue = "0") int pagina,
						 @RequestParam(name = "registros", defaultValue = "10") int registros) {
		
		return  ResponseEntity.ok().body(this.escolaService.paginacao(pagina, registros));
		
	}
	

}
