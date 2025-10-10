package br.com.beecrowd.problemas.iniciante.impl;

import br.com.beecrowd.problemas.iniciante.Executavel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SalarioComBonus implements Executavel {

	@Override
	public String execute() {
		return retornaMensagem(calculaBonus(input()));
	}

	private static String retornaMensagem(BigDecimal resultado) {
		// Monta a string sem quebras de linha no início ou fim do bloco de texto
		return String.format(Locale.US, "TOTAL = R$ %.2f", resultado);
	}

	private BigDecimal calculaBonus(List<Object> input) {
		var salario = new BigDecimal(input.get(1).toString());
		var bonus = new BigDecimal(input.get(2).toString())
				.multiply(new BigDecimal("15"))
				.divide(new BigDecimal("100"), 2, RoundingMode.HALF_EVEN);

		return salario.add(bonus);
	}

	private List<Object> input() {
		try (Scanner in = new Scanner(System.in)) {
			String a = in.next();
			BigDecimal b = in.nextBigDecimal();
			BigDecimal c = in.nextBigDecimal();

			return List.of(a, b, c);
		}
	}
}
