package br.com.beecrowd.problemas.iniciante.impl;

import br.com.beecrowd.problemas.iniciante.Executavel;

import java.util.List;
import java.util.Scanner;

public class ExtremamenteBasico implements Executavel {
	@Override
	public String execute() {
		List<Integer> numeros = input();
		return retornaMensagem(soma(numeros.get(0), numeros.get(1)));
	}

	private String retornaMensagem(Integer resultado){
		return "X = " + resultado;
	}

	private List<Integer> input(){
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			return List.of(a, b);
		}
	}

	private int soma(int a, int b) {
		return a + b;
	}
}
