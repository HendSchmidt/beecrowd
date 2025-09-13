package br.com.beecrowd.problemas;

import br.com.beecrowd.problemas.iniciante.impl.Salario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeecrowdApplication {

	public static void main(String[] args) {
		Salario salario = new Salario();
		System.out.println(salario.execute());
		SpringApplication.run(BeecrowdApplication.class, args);
	}

}
