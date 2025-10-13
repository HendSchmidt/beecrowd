package br.com.beecrowd.problemas.iniciante.arrange;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class NotasEMoedasArrange {
    static Stream<Arguments> arrangeCorreto() {
        return Stream.of(
                Arguments.of("576.73",
                        """
                                NOTAS:
                                5 nota(s) de R$ 100.00
                                1 nota(s) de R$ 50.00
                                1 nota(s) de R$ 20.00
                                0 nota(s) de R$ 10.00
                                1 nota(s) de R$ 5.00
                                0 nota(s) de R$ 2.00
                                MOEDAS:
                                1 moeda(s) de R$ 1.00
                                1 moeda(s) de R$ 0.50
                                0 moeda(s) de R$ 0.25
                                2 moeda(s) de R$ 0.10
                                0 moeda(s) de R$ 0.05
                                3 moeda(s) de R$ 0.01"""),
                Arguments.of("4.00",
                        """
                                NOTAS:
                                0 nota(s) de R$ 100.00
                                0 nota(s) de R$ 50.00
                                0 nota(s) de R$ 20.00
                                0 nota(s) de R$ 10.00
                                0 nota(s) de R$ 5.00
                                2 nota(s) de R$ 2.00
                                MOEDAS:
                                0 moeda(s) de R$ 1.00
                                0 moeda(s) de R$ 0.50
                                0 moeda(s) de R$ 0.25
                                0 moeda(s) de R$ 0.10
                                0 moeda(s) de R$ 0.05
                                0 moeda(s) de R$ 0.01"""),
                Arguments.of("91.01",
                        """
                                NOTAS:
                                0 nota(s) de R$ 100.00
                                1 nota(s) de R$ 50.00
                                2 nota(s) de R$ 20.00
                                0 nota(s) de R$ 10.00
                                0 nota(s) de R$ 5.00
                                0 nota(s) de R$ 2.00
                                MOEDAS:
                                1 moeda(s) de R$ 1.00
                                0 moeda(s) de R$ 0.50
                                0 moeda(s) de R$ 0.25
                                0 moeda(s) de R$ 0.10
                                0 moeda(s) de R$ 0.05
                                1 moeda(s) de R$ 0.01 """));
    }

}
