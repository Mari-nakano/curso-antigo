package com.brq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brq.models.TipoCliente;

@Repository
								//dois elementos, primeiro daonde precisamos, e o tipo da PK
public interface TipoClienteRepository extends JpaRepository<TipoCliente, String> {

		
		

}
