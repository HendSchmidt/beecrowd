package br.com.beecrowd.problemas.iniciante.impl;

import br.com.beecrowd.problemas.iniciante.Executavel;

import java.util.List;
import java.util.Scanner;

public class ProdutoSimples implements Executavel {
	@Override
	public String execute() {
		return retornaMensagem(calculaProduto(input()));
	}

	private Integer calculaProduto(List<Integer> numeros) {
		return numeros.stream().reduce(1, (a, b) -> a * b);
	}

	private List<Integer> input() {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		return List.of(a, b);
	}

	private String retornaMensagem(Integer resultado) {
		return "PROD = " + resultado;
	}
}
