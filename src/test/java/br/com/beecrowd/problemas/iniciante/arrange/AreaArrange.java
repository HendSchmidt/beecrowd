package br.com.beecrowd.problemas.iniciante.arrange;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AreaArrange {
	static Stream<Arguments> arrangeCorreto(){
		String arrange = "3.0 4.0 5.2";
		String resultadoEsperado = "TRIANGULO: 7.800\n" +
				"CIRCULO: 84.949\n" +
				"TRAPEZIO: 18.200\n" +
				"QUADRADO: 16.000\n" +
				"RETANGULO: 12.000";

		String arrange1 = "12.7 10.4 15.2";
		String resultadoEsperado1 = "TRIANGULO: 96.520\n" +
				"CIRCULO: 725.833\n" +
				"TRAPEZIO: 175.560\n" +
				"QUADRADO: 108.160\n" +
				"RETANGULO: 132.080";

		return Stream.of(arguments(arrange, resultadoEsperado), arguments(arrange, resultadoEsperado));
	}
}
