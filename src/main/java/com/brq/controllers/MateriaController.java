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

import com.brq.dtos.MateriaDTO;
import com.brq.services.MateriaService;

@RequestMapping("materia")
@RestController
public class MateriaController {
	
	@Autowired
	private MateriaService materiaService;
	
	
	@GetMapping("")
	public ResponseEntity<List<MateriaDTO>> findAll() {
		return ResponseEntity.ok().body(this.materiaService.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<MateriaDTO> getOne(@PathVariable int id) {
		return ResponseEntity.ok().body(this.materiaService.findOne(id));
	}

	@GetMapping("materia-por-nome/{nome}")
	public ResponseEntity<List<MateriaDTO>> getByName(@PathVariable String nome) {
		return ResponseEntity.ok().body(this.materiaService.findByNome(nome));
	}
	
	@PostMapping("")
	public ResponseEntity<MateriaDTO> save(@Valid @RequestBody MateriaDTO obj) {
		return ResponseEntity.ok().body(this.materiaService.save(obj));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<MateriaDTO> update(@Valid @RequestBody MateriaDTO novaMateria, @PathVariable int id) {
		return ResponseEntity.ok().body(this.materiaService.update(novaMateria, id));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.materiaService.delete(id);
	}
	
	@DeleteMapping("many/{id}")
	public void deleteMany(@PathVariable int[] id) {
		
		this.materiaService.deleteMany(id);
	} 	
	
	@GetMapping("paginacao")
	public ResponseEntity< Page<MateriaDTO> > paginacao(@RequestParam(name = "pagina", defaultValue = "0") int pagina,
						 @RequestParam(name = "registros", defaultValue = "10") int registros) {
		
	//	Page<MateriaDTO> pageDTO = this.materiaService.paginacao(pagina, registros);
		
	//	return  ResponseEntity.ok().body(pageDTO);
		return  ResponseEntity.ok().body(this.materiaService.paginacao(pagina, registros));
		
	}
	

}
