package br.com.beecrowd.problemas.iniciante.impl;

import br.com.beecrowd.problemas.iniciante.Executavel;

import java.util.List;
import java.util.Scanner;

public class Diferenca implements Executavel {
	@Override
	public String execute() {
		List<Integer> numeros = input();

		return retornaMensagem(
				calcularDiferenca(
						calculaProduto(numeros.stream().limit(cortarPelaMetade(numeros)).toList()),
						calculaProduto(numeros.stream().skip(cortarPelaMetade(numeros)).toList())));
	}

	private Integer calcularDiferenca(Integer produtos1, Integer produtos2) {
		return produtos1 - produtos2;
	}

	private Integer cortarPelaMetade(List<Integer> numeros) {
		return (numeros.size()) / 2;
	}

	private Integer calculaProduto(List<Integer> numeros) {
		return numeros.stream().reduce(1, (a, b) -> a * b);
	}

	private List<Integer> input() {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		return List.of(a, b, c, d);
	}

	private String retornaMensagem(Integer resultado) {
		return "DIFERENCA = " + resultado;
	}
}
