package br.com.beecrowd.problemas.iniciante.impl;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class HelloWorld implements Executavel {
	@Override
	public String execute() {
		return "Hello World!";
	}
}
