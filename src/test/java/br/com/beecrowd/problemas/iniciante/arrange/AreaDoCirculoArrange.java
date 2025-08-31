package br.com.beecrowd.problemas.iniciante.arrange;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AreaDoCirculoArrange {
	static Stream<Arguments> calculaInput(){
		return Stream.of(arguments(2.00, "12.5664"), arguments(100.64, "31819.3103"), arguments(150.00, "70685.7750"));
	}

	static Stream<Arguments> areaCorreta(){
		return Stream.of(arguments(2.00, 12.56636), arguments(100.64, 31819.310315264003), arguments(150.00, 70685.7750));
	}

	static Stream<Arguments> mensagemCorreta(){
		return Stream.of(arguments(2.00, "A=12.5664"), arguments(100.64, "A=31819.3103"), arguments(150.00, "A=70685.7750"));
	}
}
