//package com.brq.controllers;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.brq.models.AlunoModel;
//import com.brq.services.AlunoService;
//
//@RestController
//public class AlunoController {
//	
//	private ArrayList<AlunoModel> alunos = new ArrayList<>();
//	
//	//spring vai ser responsavel por fazer a alocação dele
//	@Autowired
//	private AlunoService alunoService;
//	
//	
//	@GetMapping("alunos")
//	public ArrayList<AlunoModel> getAll(){
//		return this.alunos;
//	}
//	
//	@GetMapping("alunos/{matricrula}")
//	
//	// podemos alterar o nome dentro da chave para o que quisermos, mas temos que incluir
//	// o mesmo nome apos o Pathvariable.
//	public AlunoModel getByMatricula(@PathVariable("matricrula") int matricula, @RequestParam(value="q", defaultValue = "") String query) {
//		
//		AlunoModel response = this.alunoService.findByMatricula(alunos, matricula);
//		
//		return response;
//		
//	}
//	
//	@PostMapping("alunos")
//	public AlunoModel save ( @RequestBody AlunoModel novoAluno) {
//		this.alunos.add(novoAluno);
//		return novoAluno;
//
//	}
//	
//	
////	@PatchMapping("alunos/{matricula}")
////	public AlunoModel update(@PathVariable int matricula, @RequestBody AlunoModel novoAluno) {
////		
////		AlunoModel response = null;
////		
////		for (AlunoModel aluno : alunos) {
////			if (aluno.getMatricula() == matricula) {
////				
////				//aluno.setMatricula( novoAluno.getMatricula() );
////				if (novoAluno.getNome() != null)
////					aluno.setNome(novoAluno.getNome() );
////				if (novoAluno.getTurma() != null)
////					aluno.setTurma(novoAluno.getTurma() );
////				
////				response = aluno;
////				
////			}
////		}
////		
////		return response;
////		
////	}
//	
//	
//	@DeleteMapping("alunos/{matricula}")
//	public String delete(@PathVariable int matricula) {
//		String msg = "";
//		int del = 0;
//		for (int i = 0; i <alunos.size();i++) {
//			if (alunos.get(i).getMatricula()== matricula) {	
//				
//				alunos.remove(i);
//				msg = "Aluno deletado!";
//				del = 1;
//			}
//		}
//		
//		if (del != 1) { 
//			msg = "aluno nao encontrado";
//				
//		}
//		
//		return msg;
//		
//	}
//	
//	
//
//}
