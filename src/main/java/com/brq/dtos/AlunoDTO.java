package com.brq.dtos;

import org.modelmapper.ModelMapper;

import com.brq.models.AlunoModel;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AlunoDTO {
	
	private int matricula;
	
	@NotNull(message = "Mensagem personalizada. Não pode ser nulo")
	private String nome;
	private String turma;

	
	public AlunoModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, AlunoModel.class);
	}

}
