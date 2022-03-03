package com.brq.repositories;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brq.models.EnderecoModel;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Integer>{
	
//	List<EnderecoModel> findByLogradouroContains(String logradouro);
	@Modifying
	@Transactional
	@Query (value = "DELETE FROM endereco e where aluno_id = :aluno", nativeQuery = true)
	void deleteByAluno(@Param("aluno") int aluno);
	
	void deleteByAlunoObjMatricula(int id);
	
	

}
