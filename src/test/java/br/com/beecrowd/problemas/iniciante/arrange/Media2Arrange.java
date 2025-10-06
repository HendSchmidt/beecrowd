package br.com.beecrowd.problemas.iniciante.arrange;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Media2Arrange {
	static Stream<Arguments> mediaPonderadaCorreta(){
		return Stream.of(arguments(5.0, 6.0, 7.0, "MEDIA = 6.3"), arguments(5.0, 10.0, 10.0, "MEDIA = 9.0"), arguments(10.0, 10.0, 5.0, "MEDIA = 7.5"));
	}
}
