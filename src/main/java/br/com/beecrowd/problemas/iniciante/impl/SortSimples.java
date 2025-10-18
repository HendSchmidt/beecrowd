package br.com.beecrowd.problemas.iniciante.impl;

import java.util.List;
import java.util.Scanner;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class SortSimples implements Executavel {

    @Override
    public String execute() {
        return ordenaLista(input());
    }

    private String ordenaLista(List<Integer> numeros) {
        StringBuilder res = new StringBuilder();

        numeros.stream().sorted().forEach(i -> res.append(i).append("\n"));
        res.append("\n");
        numeros.forEach(i -> res.append(i).append("\n"));
        res.deleteCharAt(res.length() -1);
        
        return res.toString();
    }

    private List<Integer> input() {
        try (Scanner in = new Scanner(System.in)) {
            return List.of(in.nextInt(), in.nextInt(), in.nextInt());
        }
    }
}
