package br.com.beecrowd.problemas.iniciante.impl;

import java.util.List;
import java.util.Scanner;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class IdadeEmDias implements Executavel {

    @Override
    public String execute() {
        return retornaMensagem(converteDiasEmAnos(input()));
    }

    private static String retornaMensagem(List<Integer> periodo) {
        return String.format("%d ano(s)\n%d mes(es)\n%d dia(s)", periodo.get(0), periodo.get(1), periodo.get(2));
    }

        private List<Integer> converteDiasEmAnos(int dias) {
            int ano = 365;
            int mes = 30;

            int anos = dias / ano;
            int meses = (dias % ano) / mes;
            int diasRestantes = (dias % ano) % mes;

           return List.of(anos, meses, diasRestantes)   ;
    }

    private int input() {
        try (Scanner in = new Scanner(System.in)) {
            return in.nextInt();
        }
    }

}
