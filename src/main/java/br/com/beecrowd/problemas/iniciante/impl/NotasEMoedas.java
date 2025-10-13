package br.com.beecrowd.problemas.iniciante.impl;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class NotasEMoedas implements Executavel {

    @Override
    public String execute() {
        return retornaMensagem(calcularCedulasNotas(input()));
    }

    private static String retornaMensagem(Troco resultado) {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("NOTAS:");
        resultado.cedulas.forEach((key, value) -> {
            mensagem.append(String.format(Locale.US, "\n%d nota(s) de R$ %.2f", value.intValue(), key));
        });
        mensagem.append("\nMOEDAS:");
        resultado.moedas.forEach((key, value) -> {
            mensagem.append(String.format(Locale.US, "\n%d moeda(s) de R$ %.2f", value.intValue(), key));
        });

        return mensagem.toString();
    }

    private Troco calcularCedulasNotas(double valor) {
        List<Double> cedulas = List.of(100.0, 50.0, 20.0, 10.0, 5.0, 2.0);
        List<Double> moedas = List.of(1.0, 0.50, 0.25, 0.10, 0.05, 0.01);
        Map<Double, Double> quantidadeDeNotas = new LinkedHashMap<>();
        Map<Double, Double> quantidadeDeMoedas = new LinkedHashMap<>();
        BigDecimal valorRestante = BigDecimal.valueOf(valor);

        valorRestante = calcularTroco(cedulas, quantidadeDeNotas, valorRestante);

        calcularTroco(moedas, quantidadeDeMoedas, valorRestante);

        return new Troco(quantidadeDeNotas, quantidadeDeMoedas);

    }

    private BigDecimal calcularTroco(List<Double> itens, Map<Double, Double> quantidadeDeItens, BigDecimal valor) {
        BigDecimal valorRestante = valor;
        for (Double item : itens) {
            BigDecimal quantidade = valorRestante.divideToIntegralValue(BigDecimal.valueOf(item));
            quantidadeDeItens.put(item, quantidade.doubleValue());
            valorRestante = valorRestante.remainder(BigDecimal.valueOf(item));
        }

        return valorRestante;
    }

    private double input() {
        try (Scanner in = new Scanner(System.in)) {
            in.useLocale(Locale.US);
            return in.nextDouble();
        }
    }

    private record Troco(Map<Double, Double> cedulas, Map<Double, Double> moedas) {
    }

}
