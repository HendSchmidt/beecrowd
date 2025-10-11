package br.com.beecrowd.problemas.iniciante.impl;

import java.util.Scanner;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class Distancia implements Executavel {

    @Override
    public String execute() {
       return retornaMensagem(calculaTempoAfastamento(input()));
    }

    private static String retornaMensagem(int resultado) {
        return String.format("%d minutos", resultado);
    }

    private int calculaTempoAfastamento(Kilometros km) {
        int velocidadePrimeiroCarro = 60;
        int velocidadeSegundoCarro = 90;

        return (km.km * 60) / (velocidadeSegundoCarro -velocidadePrimeiroCarro);
    }

    private Kilometros input() {
        try (Scanner in = new Scanner(System.in)) {
            return new Kilometros(in.nextInt());
        }
    }

    private record Kilometros(int km) {}

}
