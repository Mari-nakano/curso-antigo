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

import com.brq.dtos.MateriaDTO;
import com.brq.exceptions.ObjetoNaoEncontradoException;
import com.brq.models.MateriaModel;
import com.brq.repositories.MateriaRepository;

@Service
public class MateriaService {
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	public List<MateriaDTO> findAll() {
//		List<MateriaDTO> listDTO = new ArrayList<>();
//		List<MateriaModel> list = this.materiaRepository.findAll();
//		for (MateriaModel materiaModel : list) {
//			
//			listDTO.add(materiaModel.toDTO());
//		}
//		
//		return listDTO;
		
		
		List<MateriaModel> list = this.materiaRepository.findAll();
		return list.stream()
			.map(x -> x.toDTO())
			.collect(Collectors.toCollection(ArrayList::new));
			

	}
	
	
	public MateriaDTO findOne(int id) {
		return this.materiaRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Matéria não encontrada")).toDTO();
		
	}
	
	public List<MateriaDTO> findByNome(String nome) {
		
		List<MateriaModel> list = this.materiaRepository.findByNomeContains(nome);
		return list.stream()
	            .map(x -> x.toDTO())
	            .collect(Collectors.toCollection(ArrayList::new));	
		

	}
	
	public MateriaDTO save(MateriaDTO obj) {
		return this.materiaRepository.save(obj.toEntity()).toDTO();
	}	
	
	public MateriaDTO update(MateriaDTO novaMateria, int id) {
		Optional<MateriaModel> opMateria = this.materiaRepository.findById(id);
		
		if (opMateria.isPresent()) {
			MateriaModel updated = opMateria.get();
			updated.setNome(novaMateria.getNome());
			updated.setProfessor(novaMateria.getProfessor());
			
			return this.materiaRepository.save(updated).toDTO();
		}
		
		else {
			throw new ObjetoNaoEncontradoException("Matéria não encontrada");
		}
		
	}
	
	public String delete(int id) {
		try {
			this.materiaRepository.deleteById(id);
		}
		
		catch (Exception e) {
			throw new ObjetoNaoEncontradoException("Matéria não encontrada, não pode ser deletada");
		}
			
		return "Materia deletada";
	}
	
	public void deleteMany(int[] ids) {
		for (int i : ids) {
			this.materiaRepository.deleteById(i);
		}
		
	}	
	
	public Page<MateriaDTO> paginacao(int pagina, int registros) {
		PageRequest pageRequest = PageRequest.of(pagina, registros);
		
		Page<MateriaModel> pageModel = this.materiaRepository.findAll( pageRequest );
		
		Page<MateriaDTO> pageDTO = pageModel.map(
				new Function<MateriaModel, MateriaDTO>() {
					public MateriaDTO apply(MateriaModel model) {
						return model.toDTO();
					}
				}
		);
		
		return pageDTO;
		
	}
		
}
	


