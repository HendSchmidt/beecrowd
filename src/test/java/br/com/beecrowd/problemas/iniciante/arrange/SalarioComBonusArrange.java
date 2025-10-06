package br.com.beecrowd.problemas.iniciante.arrange;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SalarioComBonusArrange {
	static Stream<Arguments> arrangeCorreto(){
		return Stream.of(arguments("JOAO", 500.00, 1230.30, "TOTAL = R$ 684.54"),
				arguments("PEDRO", 700.00, 0.00, "TOTAL = R$ 700.00"),
				arguments("MANGOJATA", 1700.00, 1230.50, "TOTAL = R$ 1884.58"));
	}
}
