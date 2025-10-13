package br.com.beecrowd.problemas.iniciante.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class Cedulas implements Executavel {

    @Override
    public String execute() {
        int valor = input();
        return retornaMensagem(calcularCedulas(valor), valor);
    }

    private static String retornaMensagem(Map<Integer, Integer> resultado, int valor) {
        StringBuilder mensagem = new StringBuilder(String.format(Locale.US, "%d", valor));

        resultado.forEach((key, value) -> {
            mensagem.append(String.format("\n%d nota(s) de R$ %d,00", value, key));
        });

        return mensagem.toString();
    }

    private Map<Integer, Integer> calcularCedulas(int valor) {
        List<Integer> cedulas = List.of(100, 50, 20, 10, 5, 2, 1);
        Map<Integer, Integer> quantidadeDeNotas = new LinkedHashMap<>();
        int valorRestante = valor;

        for (Integer cedula : cedulas) {
            int quantidade = valorRestante / cedula;
            quantidadeDeNotas.put(cedula, quantidade);
            valorRestante %= cedula; // Usa o operador módulo para obter o resto
        }

        return quantidadeDeNotas;

    }

    private int input() {
        try (Scanner in = new Scanner(System.in)) {
            return in.nextInt();
        }
    }

}
