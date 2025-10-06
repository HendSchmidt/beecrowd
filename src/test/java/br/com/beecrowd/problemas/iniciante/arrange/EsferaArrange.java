package br.com.beecrowd.problemas.iniciante.arrange;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class EsferaArrange {
	static Stream<Arguments> arrangeCorreto(){
		return Stream.of(arguments(3D, "VOLUME = 113.097"), arguments(15D, "VOLUME = 14137.155"), arguments(1523D, "VOLUME = 14797486501.627"));
	}

}
