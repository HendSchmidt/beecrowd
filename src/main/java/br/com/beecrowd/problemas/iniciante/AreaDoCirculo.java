package br.com.beecrowd.problemas.iniciante;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class AreaDoCirculo {
	private static final double pi = 3.14159;

	public String retornaMensagem(){
		return "A=" + calculaInput();
	}

	public String calculaInput() {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("0.0000", symbols);
		Scanner in = new Scanner(System.in);
		double raio = in.nextDouble();
		return df.format(calcularAreaDoCirculo(raio));
	}

	public double calcularAreaDoCirculo(double raio){
		return pi * (raio * raio);
	}
}
