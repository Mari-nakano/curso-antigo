package com.brq.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.brq.dtos.MateriaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbmateria")
public class MateriaModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "tbmateria_seq")
	@SequenceGenerator(sequenceName = "tbmateria_seq", allocationSize = 1, name = "tbmateria_seq")
	private int id;
	private String nome;
	private String professor;
	
	@JsonIgnore
	@ManyToMany (mappedBy = "materias")
	private List<AlunoModel> alunos = new ArrayList<>();
	
	public MateriaDTO toDTO() {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, MateriaDTO.class);
		
	}
}

