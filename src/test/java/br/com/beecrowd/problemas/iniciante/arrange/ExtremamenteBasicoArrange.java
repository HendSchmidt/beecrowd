package br.com.beecrowd.problemas.iniciante.arrange;

import  org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

public class ExtremamenteBasicoArrange {
	static Stream<Arguments> somaDeDoisNumeros(){
		return Stream.of(arguments(10, 9, "X = 19"), arguments(-10, 4, "X = -6"), arguments(15, -7, "X = 8"));
	}
}
