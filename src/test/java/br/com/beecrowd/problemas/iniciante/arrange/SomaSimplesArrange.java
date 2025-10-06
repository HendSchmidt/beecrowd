package br.com.beecrowd.problemas.iniciante.arrange;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SomaSimplesArrange {
	static Stream<Arguments> somaDeDoisNumeros(){
		return Stream.of(arguments(30, 10, "SOMA = 40"), arguments(-30, 10, "SOMA = -20"), arguments(0, 0, "SOMA = 0"));
	}
}
