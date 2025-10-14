package br.com.beecrowd.problemas.iniciante.impl;

import java.util.Scanner;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class TesteDeSelecaoUm implements Executavel {

    @Override
    public String execute() {
        return retornaMensagem(calculaRespostaCorreta(input()));
    }

    private String retornaMensagem(String resposta) {
        return resposta;
    }

    private String calculaRespostaCorreta(Resposta resposta) {
        if (resposta.isValido()) {
            return "Valores aceitos";
        } else {
            return "Valores nao aceitos";
        }
    }

    private Resposta input() {
        try (Scanner in = new Scanner(System.in)) {
            return new Resposta(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
        }
    }

    private record Resposta(int a, int b, int c, int d) {
        boolean isValido() {
            return (b > c && d > a && ((c + d) > (a + b)) && (c > 0 && d > 0) && a % 2 == 0);
        }
    }

}
