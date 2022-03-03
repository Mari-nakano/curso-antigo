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

import com.brq.dtos.AlunoDTO;
import com.brq.services.TBAlunoService;


@RequestMapping("tb-aluno")
@RestController
public class TBAlunoController {
	
	@Autowired
	private TBAlunoService tbAlunoService;
	
	@GetMapping("")
	public ResponseEntity<List<AlunoDTO>> findAll() {
		return ResponseEntity.ok().body(this.tbAlunoService.findAll());
	}
	
	@GetMapping("/{matricula}")
	public ResponseEntity<AlunoDTO> findOne(@PathVariable int matricula) {
		return ResponseEntity.ok().body(this.tbAlunoService.findOne(matricula));
	}
	
	@GetMapping("/aluno-por-nome/{nome}")
	public ResponseEntity<List<AlunoDTO>> findByNome(@PathVariable String nome) {
		return ResponseEntity.ok().body(this.tbAlunoService.findByNome(nome));

	}
	
	@PostMapping("")
	public ResponseEntity<AlunoDTO> save(@Valid @RequestBody AlunoDTO aluno) {
		return ResponseEntity.ok().body(this.tbAlunoService.save(aluno));
	}
	
	
	@PatchMapping("/{matricula}")
	
	public ResponseEntity<AlunoDTO> update(@PathVariable int matricula, @Valid @RequestBody AlunoDTO alterAluno) {
		
		return ResponseEntity.ok().body(this.tbAlunoService.update(matricula, alterAluno));
		
	}
	
	@DeleteMapping("/{matricula}")
	
	public void delete(@PathVariable int matricula) {
		this.tbAlunoService.delete(matricula);
		
	}
	
	@GetMapping("paginacao")
	public ResponseEntity<Page<AlunoDTO>> paginacao(@RequestParam(name = "pagina", defaultValue = "0") int pagina,
			 @RequestParam(name = "registros", defaultValue = "10") int registros) {

		return  ResponseEntity.ok().body(this.tbAlunoService.paginacao(pagina, registros));

	}
	

}
