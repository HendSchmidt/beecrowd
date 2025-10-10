package br.com.beecrowd.problemas.iniciante.impl;

import br.com.beecrowd.problemas.iniciante.Executavel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Salario implements Executavel {
	@Override
	public String execute() {
		return retornaMensagem(calculaSalario(input()));
	}

	private static String retornaMensagem(Map<String, BigDecimal> resultado) {
		// Monta a string sem quebras de linha no início ou fim do bloco de texto
		return String.format(Locale.US, "NUMBER = %.0f\nSALARY = U$ %.2f",
				resultado.get("nome"),
				resultado.get("salario"));
	}

	private List<Number> input() {
		try (Scanner in = new Scanner(System.in)) {
			Integer a = in.nextInt();
			validaInput(a);
			Integer b = in.nextInt();
			validaInput(b);
			BigDecimal c = in.nextBigDecimal();
			validaInput(c);

			return List.of(a, b, c);
		}
	}

	private void validaInput(Number numero) {
		if (numero == null) {
			throw new IllegalArgumentException("Numero não deve ser nulo.");
		}

		if (numero instanceof BigDecimal numeroAuxiliar) {
			try {
				numeroAuxiliar.setScale(2, RoundingMode.UNNECESSARY);
			} catch (ArithmeticException e) {
				throw new IllegalArgumentException("Numero deve possui apenas DUAS casa decimal.");
			}
		}
	}

	private Map<String, BigDecimal> calculaSalario(List<Number> input) {
		Map<String, BigDecimal> resultado = new HashMap<>();
		resultado.put("nome", new BigDecimal(input.get(0).toString()));
		resultado.put("salario",
				new BigDecimal(input.stream().skip(1).reduce(1, this::calculaHorasTrabalhadas).toString()));
		return resultado;
	}

	private BigDecimal calculaHorasTrabalhadas(Number horas, Number valor) {
		BigDecimal a = new BigDecimal(horas.toString());
		BigDecimal b = new BigDecimal(valor.toString());

		return b.multiply(a).setScale(2, RoundingMode.UNNECESSARY);
	}
}
