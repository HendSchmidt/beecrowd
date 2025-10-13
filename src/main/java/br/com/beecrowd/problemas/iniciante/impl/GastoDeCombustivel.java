package br.com.beecrowd.problemas.iniciante.impl;

import java.util.Locale;
import java.util.Scanner;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class GastoDeCombustivel implements Executavel {

    @Override
    public String execute() {
        return retornaMensagem(calculaGastoDeCombustivel(input()));
    } 

        private static String retornaMensagem(double resultado) {
        return String.format(Locale.US, "%.3f", resultado);
    }


    private double calculaGastoDeCombustivel(Tempo tempo) {
        return tempo.getCombustivelConsumido();
    }

    private Tempo input() {
         try (Scanner in = new Scanner(System.in)) {
            return new Tempo(in.nextInt(), in.nextInt());
         }
    }

    private record Tempo(int horas, int velocidadeMedia){
        double getCombustivelConsumido(){
            double consumoDoCarroEmLitros = 12.0;

            return (this.horas * this.velocidadeMedia) / consumoDoCarroEmLitros;
        }
    }

}
