package com.brq.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.brq.dtos.EscolaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "tbescola")
public class EscolaModel {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbescola_seq")
	@SequenceGenerator(sequenceName = "tbescola_seq", allocationSize = 1, name = "tbescola_seq")
	private int id;
	
	private String nome;
	private String tipo_escola;
	private int numero_salas;
	
	@JsonIgnore
	@OneToMany(mappedBy = "escola")
	private List<AlunoModel> alunos = new ArrayList<>();
	
	public EscolaDTO toDTO() {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, EscolaDTO.class);
	}

}
