package br.com.beecrowd.problemas.iniciante.arrange;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculoSimplesArrange {
	static Stream<Arguments> arrangeCorreto(){
		String casoDeTeste = "12 1 5.30\n16 2 5.10";
		String resultadoEsperado = "VALOR A PAGAR: R$ 15.50";

		String casoDeTeste1 = "13 2 15.30\n161 4 5.20";
		String resultadoEsperado1 = "VALOR A PAGAR: R$ 51.40";

		String casoDeTeste2 = "1 1 15.10\n2 1 15.10";
		String resultadoEsperado2 = "VALOR A PAGAR: R$ 30.20";

		return Stream.of(arguments(casoDeTeste,resultadoEsperado), arguments(casoDeTeste1,resultadoEsperado1), arguments(casoDeTeste2,resultadoEsperado2));
	}
}
