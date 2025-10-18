package br.com.beecrowd.problemas.iniciante.impl;

import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class Triangulo implements Executavel {
    private static final Predicate<Numeros> verificaTriangulo = n -> n.a + n.b > n.c && n.a + n.c > n.b && n.b + n.c > n.a;
    private static final Function<Numeros, String> calculoDoPerimetro = n -> String.format(Locale.US,"Perimetro = %.1f", n.a + n.b + n.c);
    private static final Function<Numeros, String> calculoDoTrapezio = n -> String.format(Locale.US, "Area = %.1f", ((n.a + n.b) * n.c) / 2);

    @Override
    public String execute() {
        return calcularTrianguilo(input());
    }

    private String calcularTrianguilo(Numeros numeros) {
        return Stream.of(
                new Regra(verificaTriangulo, calculoDoPerimetro),
                new Regra(verificaTriangulo.negate(), calculoDoTrapezio))
                .filter(regra -> regra.condicao.test(numeros))
                .findFirst()
                .map(m -> m.mensagem.apply(numeros))
                .orElse("Fora de condição");
    }

    private Numeros input() {
        try (Scanner in = new Scanner(System.in)) {
            in.useLocale(Locale.US);
            return new Numeros(in.nextDouble(), in.nextDouble(), in.nextDouble());
        }
    }

    private record Numeros(Double a, Double b, Double c) {
    }

    private record Regra(Predicate<Numeros> condicao, Function<Numeros, String> mensagem) {
    }
}
