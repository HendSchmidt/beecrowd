package br.com.beecrowd.problemas.iniciante.impl;

import br.com.beecrowd.problemas.iniciante.Executavel;

import java.util.Locale;
import java.util.Scanner;

public class Esfera implements Executavel {
	private static final double PI = 3.14159;

	@Override
	public String execute() {
		return retornaMensagem(calculaVolumeEsfera(input()));
	}

	private static String retornaMensagem(Double resultado) {
		return String.format(Locale.US, "VOLUME = %.3f", resultado);
	}

	private Double calculaVolumeEsfera(Raio raio){
		return raio.calculaVolumeRaio(raio.raio);
	}


	private Raio input(){
		try (Scanner in = new Scanner(System.in)) {
			return new Raio(in.nextDouble());
		}
	}

	private record Raio(double raio){
		Double calculaVolumeRaio(double raio) {
			return (4.0 / 3.0) * PI * Math.pow(this.raio, 3);
		}
	}
}
