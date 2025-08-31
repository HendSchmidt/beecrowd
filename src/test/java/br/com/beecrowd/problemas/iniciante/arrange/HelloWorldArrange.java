package br.com.beecrowd.problemas.iniciante.arrange;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class HelloWorldArrange {
	static Stream<Arguments> mensagemCorreta(){
		return Stream.of(arguments("Hello World!"));
	}
}
