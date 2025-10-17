package br.com.beecrowd.problemas.iniciante.impl;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.BiFunction;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class Lanche implements Executavel {

    @Override
    public String execute() {
        return retornaMensagem(calculaTotal(input()));
    }

    private static String retornaMensagem(Double total) {
        return String.format(Locale.US, "Total: R$ %.2f", total);
    }

    private Double calculaTotal(Pedido pedido) {
        final List<RegraDePreco> estrategias = List.of(
                new RegraDePreco(calcularTotal.apply(4.00, pedido.quantidade), 1, "Cachorro Quente"),
                new RegraDePreco(calcularTotal.apply(4.50, pedido.quantidade), 2, "X-Salada"),
                new RegraDePreco(calcularTotal.apply(5.00, pedido.quantidade), 3, "X-Bacon"),
                new RegraDePreco(calcularTotal.apply(2.00, pedido.quantidade), 4, "Torrada Simples"),
                new RegraDePreco(calcularTotal.apply(1.50, pedido.quantidade), 5, "Refrigerante"));

        return estrategias.stream()
                .filter(estrategia -> estrategia.codigo() == pedido.codigo())
                .findFirst()
                .map(RegraDePreco::total)
                .orElse(0.0);
    }

    private Pedido input() {
        try (Scanner in = new Scanner(System.in)) {
            return new Pedido(in.nextInt(), in.nextInt());
        }
    }

    static BiFunction<Double, Integer, Double> calcularTotal = (preco, quantidade) -> preco * quantidade;

    private record Pedido(int codigo, int quantidade) {
    }

    private record RegraDePreco(Double total, int codigo, String nome) {
    }
}
