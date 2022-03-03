package com.brq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brq.models.MateriaModel;

@Repository
public interface MateriaRepository extends JpaRepository<MateriaModel, Integer> {
	
	/*SELECT * FROM tbmateria wherer nome =<nome> */
	@Query (value = "select * from tbmateria where nome like %:nome%", nativeQuery = true)
	List<MateriaModel> findByNomeContains(@Param("nome") String nome); 
	
	//List<MateriaModel> findByNomeContains(String nome); 	
	//List<MateriaModel> findByNomeContainsProfessorLike(String nome, String professor); 

}
