package br.com.beecrowd.problemas.iniciante.impl;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Predicate;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class Intervalo implements Executavel {

    @Override
    public String execute() {
        return calcularIntervalo(input());
    }

    private String calcularIntervalo(Double valor) {
        final List<RegraDeIntervalo> estrategias = List.of(
                new RegraDeIntervalo(verificaIntervalo(0.0, 25.0), "Intervalo [0,25]"),
                new RegraDeIntervalo(verificaIntervalo(25.01, 50.0), "Intervalo (25,50]"),
                new RegraDeIntervalo(verificaIntervalo(50.01, 75.0), "Intervalo (50,75]"),
                new RegraDeIntervalo(verificaIntervalo(75.01, 100.0), "Intervalo (75,100]"));

        return estrategias.stream()
                .filter(estrategia -> estrategia.predicate().test(valor))
                .findFirst()
                .map(RegraDeIntervalo::mensagem)
                .orElse("Fora de intervalo");
    }

    private double input() {
        try (Scanner in = new Scanner(System.in)) {
            in.useLocale(Locale.US);
            return in.nextDouble();
        }
    }

    private static Predicate<Double> verificaIntervalo(Double inicio, Double fim) {
        return valor -> valor.compareTo(inicio) >= 0 && valor.compareTo(fim) <= 0;
    }

    private record RegraDeIntervalo(Predicate<Double> predicate, String mensagem) {}
}
