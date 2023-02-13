package br.com.marcioviana.gestaovendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.marcioviana.gestaovendas.entidades"})
@EnableJpaRepositories (basePackages = {"br.com.marcioviana.gestaovendas.repository"})
@ComponentScan(basePackages = {"br.com.marcioviana.gestaovendas.service, br.com.marcioviana.gestaovendas.controller"})
public class GestaoVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoVendasApplication.class, args);
	}

}
