package br.com.beecrowd.problemas.iniciante.arrange;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ProdutoSimplesArrange {
	static Stream<Arguments> calculoProdutoSimplesCorreto(){
		return Stream.of(arguments(3, 9, "PROD = 27"), arguments(-30, 10, "PROD = -300"), arguments(0, 9, "PROD = 0"));
	}
}
