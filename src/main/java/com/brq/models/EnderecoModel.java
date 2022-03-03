package com.brq.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.brq.dtos.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table (name = "tbendereco")
public class EnderecoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbendereco_seq")
	@SequenceGenerator(sequenceName = "tbendereco_seq", allocationSize = 1, name = "tbendereco_seq")
	private int id;
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
//	private int aluno_id;
	
	//a variavel aluno vai trazer os objetos do AlunoMovel
	@JsonIgnore	
	@OneToOne 
	@JoinColumn (name = "aluno_id")
	private AlunoModel alunoObj;

	public EnderecoDTO toDTO() {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, EnderecoDTO.class);
		
	}


}
