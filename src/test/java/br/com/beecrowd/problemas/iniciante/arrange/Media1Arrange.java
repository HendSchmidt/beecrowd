package br.com.beecrowd.problemas.iniciante.arrange;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Media1Arrange {
	static Stream<Arguments> calculoMediaCorreto(){
		return Stream.of(arguments(5.0, 7.1, "MEDIA = 6.43182"), arguments(0.0, 7.1, "MEDIA = 4.84091"), arguments(10.0, 10.0, "MEDIA = 10.00000"));
	}
}
