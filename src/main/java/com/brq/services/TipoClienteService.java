package com.brq.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.dtos.TipoClienteDTO;
import com.brq.exceptions.ObjetoNaoEncontradoException;
import com.brq.models.TipoCliente;
import com.brq.repositories.TipoClienteRepository;


@Service
public class TipoClienteService {
	
	@Autowired
	private TipoClienteRepository tipoClienteRepository;
	
	public List<TipoClienteDTO> findAll() {
		
		List<TipoCliente> list = this.tipoClienteRepository.findAll();
		return list.stream()
				.map(x -> x.toDTO())
				.collect(Collectors.toCollection(ArrayList::new));
		
	}
	

	public TipoClienteDTO findOne(String codtipocli) {
//		Optional<TipoCliente> opTipoCli = this.tipoClienteRepository.findById(codtipocli);
//		
//		if (opTipoCli.isPresent()) {
//			return opTipoCli.get();
//		}
//		else {
//			//return null;
//			throw new RuntimeException("Registro não encontrado");
//		}
		
		//return this.tipoClienteRepository.findById(codtipocli).orElse( new TipoCliente() );
		return this.tipoClienteRepository.findById(codtipocli)
				.orElseThrow( () -> new ObjetoNaoEncontradoException("Registro não localizado")).toDTO();
	}
	
	public TipoClienteDTO save(TipoClienteDTO novoTipoCliente) {
		return this.tipoClienteRepository.save(novoTipoCliente.toEntity()).toDTO();
	}
	
	public TipoClienteDTO update(String codtipocli, TipoClienteDTO alterarTipoCliente) {
		Optional<TipoCliente> opTipoCli = this.tipoClienteRepository.findById(codtipocli);
		
		if (opTipoCli.isPresent()) {
			TipoCliente updated = opTipoCli.get();
			updated.setDesctipocli(alterarTipoCliente.getDesctipocli());
			return this.tipoClienteRepository.save(updated).toDTO();
			
		}
		else {
			return null;
		}
	}
	
//	public void delete(String codtipocli) {
//		
//		try {
//			this.tipoClienteRepository.deleteById(codtipocli);
//		}
//		catch (Exception e) {
//			throw new RuntimeException("Erro ao deletar registro" + e.getMessage());
//		}
//		
//	}
	
	public void delete(String codtipocli) {
		
		try {
			this.tipoClienteRepository.deleteById(codtipocli);
		}
		catch (Exception e) {
			throw new ObjetoNaoEncontradoException("Erro ao deletar registro");
		}
		
	}
	
	

}
