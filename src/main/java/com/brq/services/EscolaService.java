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

import com.brq.dtos.EscolaDTO;
import com.brq.exceptions.ObjetoNaoEncontradoException;
import com.brq.models.EscolaModel;
import com.brq.repositories.EscolaRepository;

@Service
public class EscolaService {
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	public List<EscolaDTO> findAll() {
		List<EscolaModel> listAl = this.escolaRepository.findAll();
		return listAl.stream()
			.map(x -> x.toDTO())
			.collect(Collectors.toCollection(ArrayList::new));
		
	}
	
	public EscolaDTO findOne(int matricula) {
		return this.escolaRepository.findById(matricula).orElseThrow(() -> new ObjetoNaoEncontradoException("Registro não localizado")).toDTO();
	}
	
	public List<EscolaDTO> findByNome(String nome) {
		
		List<EscolaModel> listAl = this.escolaRepository.findByNome(nome);
		return listAl.stream()
			.map(x -> x.toDTO())
			.collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	public EscolaDTO save(EscolaDTO escola) {
		return this.escolaRepository.save(escola.toEntity()).toDTO();
	}
	
	
	public EscolaDTO update(int id, EscolaDTO novaEscola) {
		Optional<EscolaModel> opEscola = this.escolaRepository.findById(id);
		
		if (opEscola.isPresent()) {
			EscolaModel updated = opEscola.get();
			updated.setNome(novaEscola.getNome());
//			updated.setNumero_salas(novaEscola.getNumero_salas());
			updated.setTipo_escola(novaEscola.getTipo_escola());
			return this.escolaRepository.save(updated).toDTO();
		}
		
		else {
			throw new ObjetoNaoEncontradoException("Escola não encontrada");
		}
	}
	
	
	public void delete(int id) {
		
		try {
			this.escolaRepository.deleteById(id);
		}
		catch (Exception e) {
			throw new ObjetoNaoEncontradoException("Erro ao deletar registro");
		}
		
	}
	
	public Page<EscolaDTO> paginacao(int pagina, int registros) {
		PageRequest pageRequest = PageRequest.of(pagina, registros);
		
		Page<EscolaModel> pageModel = this.escolaRepository.findAll( pageRequest );
		
		Page<EscolaDTO> pageDTO = pageModel.map(
				new Function<EscolaModel, EscolaDTO>() {
					public EscolaDTO apply(EscolaModel model) {
						return model.toDTO();
					}
				}
		);
		
		return pageDTO;
		
	}

}
