package br.com.beecrowd.problemas.iniciante.impl;

import java.util.Locale;
import java.util.Scanner;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class Consumo implements Executavel {

    @Override
    public String execute() {
        return retornaMensagem(calcularConsumo(input()));
    }

    private static String retornaMensagem(double resultado) {
        return String.format(Locale.US, "%.3f km/l", resultado);
    }

    private double calcularConsumo(ConsumoCombustivel consumo) {
        return consumo.getConsumo();
    }

    private ConsumoCombustivel input() {
        try (Scanner in = new Scanner(System.in)) {
            in.useLocale(Locale.US);
            return new ConsumoCombustivel(in.nextInt(), in.nextDouble());
        }
    }

    private record ConsumoCombustivel(int distancia, double combustivel) {
        public double getConsumo() {
            return distancia / combustivel;
        }
    }

}
