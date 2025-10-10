package br.com.beecrowd.problemas.iniciante.impl;

import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class DistanciaEntreDoisPontos implements Executavel {

    @Override
    public String execute() {
        return retornaMensagem(calculaDistancia(input()));
    }

    private static String retornaMensagem(double resultado) {
        return String.format(Locale.US, "%.4f", resultado);
    }

    private double calculaDistancia(List<Pontos> listaPontos) {
        return listaPontos.get(0).getDistancia(listaPontos.get(1).x, listaPontos.get(1).y);
    }

    private List<Pontos> input() {
        try (java.util.Scanner in = new java.util.Scanner(System.in)) {
            in.useLocale(Locale.US);

            return IntStream.range(0, 2).mapToObj(i -> new Pontos(in.nextDouble(), in.nextDouble())).toList();
        }
    }

    private record Pontos(double x, double y) {
        double getDistancia(double x, double y) {
            return Math.sqrt(Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2));

        }
    }

}
