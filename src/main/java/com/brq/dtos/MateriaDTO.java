package com.brq.dtos;

import org.modelmapper.ModelMapper;

import com.brq.models.MateriaModel;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//criar os getters and setters
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MateriaDTO {
	
	private int id;
	@NotNull (message = "Mensagem personalizada. Não pode ser nulo")
	private String nome;
	@Size(min = 3, max = 40)
	private String professor;
	
	public MateriaModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, MateriaModel.class);
	}
	
}
