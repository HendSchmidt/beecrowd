package br.com.beecrowd.problemas.iniciante.impl;

import java.util.Scanner;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class OMaior implements Executavel {

    @Override
    public String execute() {
        return retornaMensagem(calculaMaior(input()));
    }

    private static String retornaMensagem(Integer resultado) {
        return String.format("%d eh o maior", resultado);
    }

    private Integer calculaMaior(Maior maior) {
        return maior.getMaior(maior.getMaior(maior.a, maior.b), maior.c);
    }

    private Maior input() {
        Scanner in = new Scanner(System.in);
        return new Maior(in.nextInt(), in.nextInt(), in.nextInt());
    }

    private record Maior(int a, int b, int c) {
        int getMaior(int a, int b) {
            return (a + b + Math.abs(a - b)) / 2;
        }
    }

}
