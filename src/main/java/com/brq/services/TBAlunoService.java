package com.brq.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brq.dtos.AlunoDTO;
import com.brq.exceptions.ObjetoNaoEncontradoException;
//import com.brq.models.AlunoMateriaModel;
import com.brq.models.AlunoModel;
//import com.brq.repositories.AlunoMateriaRepository;
import com.brq.repositories.AlunoRepository;
//import com.brq.repositories.EnderecoRepository;

@Service
public class TBAlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
//	@Autowired
//	private EnderecoRepository enderecoRepository;
	
//	@Autowired
//	private AlunoMateriaRepository alunoMateriaRepository;
	
	public List<AlunoDTO> findAll() {
		List<AlunoModel> list = this.alunoRepository.findAll();
		return list.stream()
				.map(x -> x.toDTO())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public AlunoDTO findOne(int matricula) {
		return this.alunoRepository.findById(matricula).orElseThrow(() -> new ObjetoNaoEncontradoException("Registro não localizado")).toDTO();
	}
	
	public List<AlunoDTO> findByNome(String nome) {
		List<AlunoModel> list = this.alunoRepository.findByNome(nome);
		return list.stream()
				.map(x -> x.toDTO())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	public AlunoDTO save(AlunoDTO aluno) {
		return this.alunoRepository.save(aluno.toEntity()).toDTO();
	}
	
	
	public AlunoDTO update(int matricula, AlunoDTO alterAluno) {
		Optional<AlunoModel> opAluno = this.alunoRepository.findById(matricula);
		
		if (opAluno.isPresent()) {
			AlunoModel updated = opAluno.get();
			updated.setNome(alterAluno.getNome());
			updated.setTurma(alterAluno.getTurma());
			return this.alunoRepository.save(updated).toDTO();
		}
		
		else {
			throw new ObjetoNaoEncontradoException("Aluno não encontrado");
		}
	}
	
	
	public void delete(int matricula) {
		
		try {
			this.alunoRepository.deleteById(matricula);
		}
		catch (Exception e) {
			throw new ObjetoNaoEncontradoException("Erro ao deletar registro");
		}
		
	}

	
	@Transactional
//	public void delete(int matricula) {
//		
////		List<AlunoMateriaModel> list = this.alunoMateriaRepository.findByAlunoId(matricula);
////		
////		if(list.size() > 0) {
////			for (AlunoMateriaModel alunoMateriaModel : list) {
////				this.alunoMateriaRepository.deleteById(alunoMateriaModel.getId());
////			}
////		}
//		
//	//	this.enderecoRepository.deleteByAluno(matricula);
//		this.enderecoRepository.deleteByAlunoObjMatricula(matricula);
//
//		
//	//	this.alunoRepository.delete(matricula);
//		this.alunoRepository.deleteById(matricula);
//	}
	
	
	
	
	public Page<AlunoDTO> paginacao(int pagina, int registros) {
		PageRequest pageRequest = PageRequest.of(pagina, registros);
		
		Page<AlunoModel> pageModel = this.alunoRepository.findAll( pageRequest );
		
		Page<AlunoDTO> pageDTO = pageModel.map(
				new Function<AlunoModel, AlunoDTO>() {
					public AlunoDTO apply(AlunoModel model) {
						return model.toDTO();
					}
				}
		);
		
		return pageDTO;
		
	}

}
