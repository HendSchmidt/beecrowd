package br.com.beecrowd.problemas.iniciante.impl;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class FormulaDeBhaskara implements Executavel {

    @Override
    public String execute() {
        return retornaMensagem(calcularBhaskara(input()));
    }

    private static String retornaMensagem(Map<String, String> resultados) {
        if (resultados.containsKey("invalido")) {
            return resultados.get("invalido");
        }

        return "R1 = " + resultados.get("R1") + "\nR2 = " + resultados.get("R2");
    }

    private Map<String, String> calcularBhaskara(Valores valores) {
        if (!valores.isValido()) {
            return Map.of("invalido", "Impossivel calcular");
        }

        return Map.of(
                "R1", String.format(Locale.US, "%.5f", valores.calculaR1()),
                "R2", String.format(Locale.US, "%.5f", valores.calculaR2()));
    }

    private Valores input() {
        try (Scanner in = new Scanner(System.in)) {
            in.useLocale(Locale.US);
            return new Valores(in.nextDouble(), in.nextDouble(), in.nextDouble());
        }
    }

    private record Valores(double a, double b, double c) {
        boolean isValido() {
            return a != 0 && calculaDelta() >= 0;
        }

        double calculaDelta() {
            return (b * b) - (4 * a * c);
        }

        double calculaR1() {
            return (-b + Math.sqrt(calculaDelta())) / (2 * a);
        }

        double calculaR2() {
            return (-b - Math.sqrt(calculaDelta())) / (2 * a);
        }
    }

}
