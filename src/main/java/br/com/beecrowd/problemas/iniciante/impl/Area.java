package br.com.beecrowd.problemas.iniciante.impl;

import br.com.beecrowd.problemas.iniciante.Executavel;

import java.util.*;

public class Area implements Executavel {
	@Override
	public String execute() {
		return retornaMensagem(calculaArea(input()));
	}

	private static String retornaMensagem(ResultadosArea resultado) {
		return String.format(Locale.US, "TRIANGULO: %.3f\nCIRCULO: %.3f\n" +
						"TRAPEZIO: %.3f\nQUADRADO: %.3f\nRETANGULO: %.3f",
				resultado.triangulo(),
				resultado.circulo(),
				resultado.trapezio(),
				resultado.quadrado(),
				resultado.retangulo());
	}

	private ResultadosArea calculaArea(AreaInput input) {
		return new ResultadosArea(input.getAreaTriangulo(),
				input.getAreaCirculo(),
				input.getAreaTrapezio(),
				input.getAreaQuadrado(),
				input.getAreaRetangulo());
	}

	private AreaInput input() {
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);

		return new AreaInput(in.nextDouble(), in.nextDouble(), in.nextDouble());
	}

	private record AreaInput(double a, double b, double c) {
		private static final double PI = 3.14159;

		double getAreaTriangulo() {
			return (this.a * this.c) / 2.0;
		}

		double getAreaCirculo() {
			return PI * Math.pow(this.c, 2);
		}

		double getAreaTrapezio() {
			return ((this.a + this.b) * c) / 2.0;
		}

		double getAreaQuadrado() {
			return Math.pow(this.b, 2);
		}

		double getAreaRetangulo() {
			return this.a * this.b;
		}
	}

	private record ResultadosArea(double triangulo,
								  double circulo,
								  double trapezio,
								  double quadrado,
								  double retangulo) {
	}
}
