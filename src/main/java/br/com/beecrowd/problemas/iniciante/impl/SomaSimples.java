package br.com.beecrowd.problemas.iniciante.impl;

import br.com.beecrowd.problemas.iniciante.Executavel;

import java.util.List;
import java.util.Scanner;

public class SomaSimples implements Executavel {
	@Override
	public String execute() {
		return retornaMensagem(soma(input()));
	}

	private String retornaMensagem(Integer resultado){
		return "SOMA = " + resultado;
	}

	private List<Integer> input(){
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			return List.of(a, b);
		}
	}

	private int soma(List<Integer> numeros) {
		return numeros.stream().reduce(0, Integer::sum);
	}
}
