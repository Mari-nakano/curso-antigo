package com.brq.dtos;

import javax.persistence.Id;

import org.modelmapper.ModelMapper;


import com.brq.models.TipoCliente;

import lombok.Data;

@Data
public class TipoClienteDTO {

	@Id
	private String codtipocli;
	private String desctipocli;
	
	
	public TipoCliente toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, TipoCliente.class);
	}
	
}
