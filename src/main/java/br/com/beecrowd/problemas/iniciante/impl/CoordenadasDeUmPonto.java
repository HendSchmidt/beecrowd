package br.com.beecrowd.problemas.iniciante.impl;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Function;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class CoordenadasDeUmPonto implements Executavel {
    private static final Map<BiPredicate<Double, Double>, String> ESTRATEGIAS = Map.ofEntries(
            Map.entry((BiPredicate<Double, Double>) (x, y) -> x > 0 && y > 0, "Q1"),
            Map.entry((BiPredicate<Double, Double>) (x, y) -> x < 0 && y < 0, "Q2"),
            Map.entry((BiPredicate<Double, Double>) (x, y) -> x < 0 && y > 0, "Q3"),
            Map.entry((BiPredicate<Double, Double>) (x, y) -> x > 0 && y < 0, "Q4"));

    @Override
    public String execute() {
        return calculaQuadrante(input());
    }

    private String calculaQuadrante(Coordenadas coordenadas) {
        StringBuilder resultado = new StringBuilder();

        return resultado
                .append(ESTRATEGIAS.entrySet()
                        .stream()
                        .filter(estrategia -> estrategia.getKey().test(coordenadas.x, coordenadas.y))
                        .findFirst()
                        .map(Map.Entry::getValue)
                        .map(Function.identity())
                        .orElse("Origem"))
                .toString();
    }

    private Coordenadas input() {
        try (Scanner in = new Scanner(System.in)) {
            in.useLocale(Locale.US);
            return new Coordenadas(in.nextDouble(), in.nextDouble());
        }
    }

    private record Coordenadas(double x, double y) {
    }
}
