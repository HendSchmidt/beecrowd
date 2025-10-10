package br.com.beecrowd.problemas.iniciante.impl;

import br.com.beecrowd.problemas.iniciante.Executavel;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class AreaDoCirculo implements Executavel {
	private static final double pi = 3.14159;

	@Override
	public String execute() {
		return retornaMensagem(calculaAreaDoCirculo(input()), getDecimalFormat("0.0000", Locale.US));
	}

	private String retornaMensagem(Double resultado, DecimalFormat formato) {
		return "A=" + formato.format(resultado);
	}

	private DecimalFormat getDecimalFormat(String pattern, Locale locale) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
		return new DecimalFormat(pattern, symbols);
	}

	private double input() {
		try (Scanner in = new Scanner(System.in)) {
			return in.nextDouble();
		}
	}

	private double calculaAreaDoCirculo(double raio) {
		return pi * (raio * raio);
	}
}
