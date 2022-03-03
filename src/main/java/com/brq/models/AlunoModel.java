package com.brq.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.brq.dtos.AlunoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbaluno")
public class AlunoModel {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbaluno_seq")
	@SequenceGenerator(sequenceName = "tbaluno_seq", allocationSize = 1, name = "tbaluno_seq")
	private int matricula;
	private String nome;
	private String turma;
	
	@OneToOne (mappedBy = "alunoObj" )
	private EnderecoModel endereco;
	
	
	@ManyToOne
	@JoinColumn (name="escola_id")
	private EscolaModel escola;
	
	@ManyToMany
	@JoinTable(name = "tbaluno_materia",
				joinColumns = @JoinColumn (name = "aluno_id"),
				inverseJoinColumns = @JoinColumn(name = "materia_id"))
	private List<MateriaModel> materias = new ArrayList<>();
	
	
	public AlunoDTO toDTO() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, AlunoDTO.class);
		
	}

}
