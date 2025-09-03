package br.com.beecrowd.problemas.iniciante.impl;

import br.com.beecrowd.problemas.iniciante.Executavel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.stream.IntStream;

public class Media1 implements Executavel {
	List<Double> pesos = List.of(3.5, 7.5);
	@Override
	public String execute() {
		return retornaMensagem(calculaMedia(input(), pesos), getDecimalFormat("0.00000", Locale.US));
	}

	private Double calculaMedia(List<Double> numeros, List<Double> pesos){
		return somaPonderada(numeros, pesos) / somaDosPesos(pesos);
	}

	private List<Double> input(){
		Scanner in = new Scanner(System.in);
		double a = in.nextDouble();
		validaInput(a);
		double b = in.nextDouble();
		validaInput(b);

		return List.of(a, b);
	}

	private String retornaMensagem(Double resultado, DecimalFormat formato){
		return "MEDIA = " + formato.format(resultado);
	}

	private DecimalFormat getDecimalFormat(String pattern, Locale locale) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
		return new DecimalFormat(pattern, symbols);
	}

	private void validaInput(Double numero){
		if(numero == null){
			throw new IllegalArgumentException("Numero não deve ser nulo.");
		}

		BigDecimal numeroAuxiliar = BigDecimal.valueOf(numero);

		if(numeroAuxiliar.compareTo(BigDecimal.ZERO) < 0 || numeroAuxiliar.compareTo(BigDecimal.TEN) > 0){
			throw new IllegalArgumentException("Numero deve estar entre ZERO e DEZ.");
		}

		try {
			numeroAuxiliar.setScale(1, RoundingMode.UNNECESSARY);
		} catch (ArithmeticException e) {
			throw new IllegalArgumentException("Numero deve possui apenas UMA casa decimal.");
		}
	}

	private Double somaDosPesos(List<Double> pesos) {
		return pesos.stream().mapToDouble(Double::doubleValue).sum();
	}

	private Double somaPonderada(List<Double> numeros, List<Double> pesos) {
		return IntStream.range(0, numeros.size()).mapToDouble(indice -> numeros.get(indice) * pesos.get(indice)).sum();
	}
}
