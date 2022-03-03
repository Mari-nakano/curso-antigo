package com.brq.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.brq.models.EnderecoModel;

import lombok.Data;

@Data
public class EnderecoDTO {
	
	private int id;
	
	@NotNull 
	private String logradouro;
	
	@NotNull
	private String numero;

	private String complemento;
	
//	private AlunoDTO aluno;
	
	
	public EnderecoModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, EnderecoModel.class);
	}
	
	//private Integer aluno;
//	public EnderecoModel toEntity() {
//		EnderecoModel endereco = new EnderecoModel();
//		
//		endereco.setId(this.id);
//		
//		AlunoModel aluno = new AlunoModel();
//		aluno.setMatricula(this.aluno);
//		
//		endereco.setAlunoObj(aluno);
//		return endereco;
//		
//  	}

}
