package com.brq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brq.models.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Integer>{
	
	List<AlunoModel> findByNome(String nome);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM aluno where matricula = :aluno", nativeQuery = true)
	void delete(int aluno);

}
