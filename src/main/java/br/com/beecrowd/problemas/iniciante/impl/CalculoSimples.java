package br.com.beecrowd.problemas.iniciante.impl;

import br.com.beecrowd.problemas.iniciante.Executavel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CalculoSimples implements Executavel {

	@Override
	public String execute() {
		return retornaMensagem(calculaValorTotal(input()));
	}

	private static String retornaMensagem(BigDecimal resultado) {
		return String.format(Locale.US, "VALOR A PAGAR: R$ %.2f", resultado);
	}

	private BigDecimal calculaValorTotal(List<Peca> listaPeca) {
		return listaPeca.stream().map(Peca::getSubTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private List<Peca> input() {
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		return IntStream.range(0, 2).mapToObj(i -> new Peca(in.nextInt(), in.nextInt(), in.nextBigDecimal())).toList();

	}

	private record Peca(int codigo, int quantidade, BigDecimal valor) {
		BigDecimal getSubTotal() {
			return valor.multiply(new BigDecimal(quantidade));
		}
	}
}
