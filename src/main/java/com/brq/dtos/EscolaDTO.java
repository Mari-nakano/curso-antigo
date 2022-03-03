package com.brq.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.brq.models.EscolaModel;

import lombok.Data;

@Data
public class EscolaDTO {
	
	@NotNull
	private String nome;
	private String tipo_escola;
	
	public EscolaModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, EscolaModel.class);
	}

}
