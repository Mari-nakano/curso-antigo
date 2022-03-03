package com.brq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brq.models.EscolaModel;

@Repository
public interface EscolaRepository extends JpaRepository<EscolaModel, Integer>{
	
	List<EscolaModel> findByNome(String nome);

}
