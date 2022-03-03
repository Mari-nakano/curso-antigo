package com.brq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brq.models.MateriaModel;


@SpringBootApplication
public class BrqApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BrqApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		MateriaModel m = new MateriaModel();
		m.setNome("Materia 1");
		
		//Builder
		MateriaModel m1 = MateriaModel
				.builder()
				.nome("Materia 2")
				.professor("Arthur")
				.build();
				
				
			
	}

}
