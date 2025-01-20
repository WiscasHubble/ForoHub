package com.aluracursos.forohub;

import com.aluracursos.forohub.Topicos.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ForohubApplication {


    public static void main(String[] args) {
		SpringApplication.run(ForohubApplication.class, args);
	}

}
