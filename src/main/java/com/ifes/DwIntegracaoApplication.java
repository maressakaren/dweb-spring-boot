package com.ifes;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@OpenAPIDefinition(info = @Info(title = "Trabalho de DW", version = "1.0", description = "Trabalho de desenvolvimento web."))
public class DwIntegracaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DwIntegracaoApplication.class, args);
	}

}
