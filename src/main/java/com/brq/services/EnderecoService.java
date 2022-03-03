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

import com.brq.dtos.EnderecoDTO;
import com.brq.exceptions.ObjetoNaoEncontradoException;
import com.brq.models.EnderecoModel;
import com.brq.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public List<EnderecoDTO> findAll() {
		List<EnderecoModel> list = this.enderecoRepository.findAll();
		return list.stream()
				.map(x -> x.toDTO())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	public EnderecoDTO findOne(int id) {
		return this.enderecoRepository.findById(id).orElseThrow( () -> new ObjetoNaoEncontradoException("Registro não localizado")).toDTO();
	}
	
//	public List<EnderecoDTO> findByLogradouro(String logradouro) {
//		List<EnderecoModel> list = this.enderecoRepository.findByLogradouroContains(logradouro);
//		return list.stream()
//			.map(x -> x.toDTO())
//			.collect(Collectors.toCollection(ArrayList::new));
//	}
	
	
	public EnderecoDTO save(EnderecoDTO endereco) {
		return this.enderecoRepository.save(endereco.toEntity()).toDTO();
	}
	
	
	public EnderecoDTO update(EnderecoDTO novoEndereco, int id) {
		Optional<EnderecoModel> opEndereco = this.enderecoRepository.findById(id);
		
		if (opEndereco.isPresent()) {
			EnderecoModel updated = opEndereco.get();
			
//				updated.setCep(novoEndereco.getCep());
				updated.setComplemento(novoEndereco.getComplemento());
				updated.setLogradouro(novoEndereco.getLogradouro());
				updated.setNumero(novoEndereco.getNumero());
			
			return this.enderecoRepository.save(updated).toDTO();
		}
		
		else {
			throw new ObjetoNaoEncontradoException("Endereço não encontrado");
		}
		
	}
	
	
	public void delete(int id) {
		
		try {
			this.enderecoRepository.deleteById(id);
		}
		
		catch (Exception e){
			throw new ObjetoNaoEncontradoException("Erro ao deletar registro");
		}
		
	}
	
	
	public Page<EnderecoDTO> paginacao(int pagina, int registros) {
		PageRequest pageRequest = PageRequest.of(pagina, registros);
		
		Page<EnderecoModel> pageModel = this.enderecoRepository.findAll( pageRequest );
		
		Page<EnderecoDTO> pageDTO = pageModel.map(
				new Function<EnderecoModel, EnderecoDTO>() {
					public EnderecoDTO apply(EnderecoModel model) {
						return model.toDTO();
					}
				}
		);
		
		return pageDTO;
		
	}
	
	
	

}
