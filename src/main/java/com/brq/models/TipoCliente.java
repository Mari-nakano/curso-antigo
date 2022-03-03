package com.brq.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;


import com.brq.dtos.TipoClienteDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbtipocli")
public class TipoCliente {
	//esta anoação indica que a variavel de baixo é a pk da table
	@Id
	private String codtipocli;
	private String desctipocli;
	
	
	public TipoClienteDTO toDTO() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, TipoClienteDTO.class);
		
	}
	
	
	

}
