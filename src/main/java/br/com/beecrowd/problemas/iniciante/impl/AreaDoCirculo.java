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
		return retornaMensagem(calculaAreaDoCirculo(input()));
	}

	private String retornaMensagem(double resultado){
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("0.0000", symbols);
		return "A=" + df.format(resultado);
	}

	private double input(){
		Scanner in = new Scanner(System.in);
		return in.nextDouble();
	}

	private double calculaAreaDoCirculo(double raio){
		return pi * (raio * raio);
	}
}
