package br.com.beecrowd.problemas.iniciante.impl;

import java.util.Locale;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class CoordenadasDeUmPonto implements Executavel {
    @Override
    public String execute() {
        return calculaQuadrante(input());
    }

    private String calculaQuadrante(Coordenadas coordenadas) {
        return Stream.of(
                new Regra((x, y) -> x == 0 && y == 0, "Origem"),
                new Regra((x, y) -> x == 0 && y != 0, "Eixo Y"),
                new Regra((x, y) -> x != 0 && y == 0, "Eixo X"),
                new Regra((x, y) -> x > 0 && y > 0, "Q1"),
                new Regra((x, y) -> x < 0 && y > 0, "Q2"),
                new Regra((x, y) -> x < 0 && y < 0, "Q3"),
                new Regra((x, y) -> x > 0 && y < 0, "Q4"))
                .filter(estrategia -> estrategia.condicao.test(coordenadas.x, coordenadas.y))
                .findFirst()
                .map(Regra::mensagem)
                .orElse("Fora de regra.");
    }

    private Coordenadas input() {
        try (Scanner in = new Scanner(System.in)) {
            in.useLocale(Locale.US);
            return new Coordenadas(in.nextDouble(), in.nextDouble());
        }
    }

    private record Regra(BiPredicate<Double, Double> condicao, String mensagem) {
    }

    private record Coordenadas(double x, double y) {
    }
}
