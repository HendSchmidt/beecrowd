package br.com.beecrowd.problemas.iniciante.impl;

import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class CoordenadasDeUmPonto implements Executavel{

    @Override
    public String execute() {
       return calculaQuadrante(input());
    }

    private String calculaQuadrante(Optional<Coordenadas> coordenadas){
        StringBuilder resultado = new StringBuilder();
        coordenadas.ifPresent(coordenada -> {
            if(coordenada.x > 0 && coordenada.y > 0){resultado.append("Q1").toString();}
            if(coordenada.x > 0 && coordenada.y < 0){resultado.append("Q4").toString();}
            if(coordenada.x < 0 && coordenada.y < 0){resultado.append("Q2").toString();}
            if(coordenada.x < 0 && coordenada.y > 0){resultado.append("Q3").toString();}
        });

            

        return resultado.isEmpty() ? resultado.append("Origem").toString() : resultado.toString();
    }

    private Optional<Coordenadas> input(){
        try (Scanner in = new Scanner(System.in)) {
            in.useLocale(Locale.US);
            return Optional.of(new Coordenadas(in.nextDouble(), in.nextDouble()));
        } 
    }

    private record Coordenadas(double x, double y){}
}
