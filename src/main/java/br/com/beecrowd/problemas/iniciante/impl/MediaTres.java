package br.com.beecrowd.problemas.iniciante.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class MediaTres implements Executavel {
    private Scanner scanner;
    private static final List<Double> pesos = List.of(2.0, 3.0, 4.0, 1.0);
    private static final BiFunction<Double, Double, Predicate<Double>> verificaIntervalo = (inicio,
            fim) -> valor -> valor.compareTo(inicio) >= 0 && valor.compareTo(fim) <= 0;
    private static final List<RegraDeIntervalo> estrategias = List.of(
            new RegraDeIntervalo(verificaIntervalo.apply(0.0, 4.9), "\nAluno reprovado."),
            new RegraDeIntervalo(verificaIntervalo.apply(5.0, 6.9), "\nAluno em exame."),
            new RegraDeIntervalo(verificaIntervalo.apply(7.0, 10.0), "\nAluno aprovado."));
    private static final List<RegraDeIntervalo> estrategiasExame = List.of(
            new RegraDeIntervalo(verificaIntervalo.apply(0.0, 4.9), "\nAluno reprovado."),
            new RegraDeIntervalo(verificaIntervalo.apply(5.0, 10.0), "\nAluno aprovado."));

    public MediaTres() {
        this.scanner = new Scanner(System.in);
        this.scanner.useLocale(Locale.US);
    }

    public MediaTres(Scanner scanner) {
        this.scanner = scanner;
        this.scanner.useLocale(Locale.US);
    }

    @Override
    public String execute() {
        return retornaMensagem(calculaMedia(input()));
    }

    private String retornaMensagem(Double media) {
        StringBuilder mensagem = new StringBuilder(String.format(Locale.US, "Media: %.1f", media));

        var resultado = estrategias.stream()
                .filter(estrategia -> estrategia.predicate().test(media))
                .findFirst();

        resultado.ifPresent(regra -> mensagem.append(regra.mensagem()));

        resultado.filter(regra -> regra.mensagem().contains("exame"))
                .ifPresent(regra -> {
                    var notaExame = new Nota(scanner.nextDouble());

                    mensagem.append(String.format(Locale.US, "\nNota do exame: %.1f", notaExame.valor()));

                    Double mediaFinal = (media + notaExame.valor) / 2;
                    
                    var regraFinal = estrategiasExame.stream()
                            .filter(estrategia -> estrategia.predicate().test(mediaFinal))
                            .findFirst();

                    mensagem.append(regraFinal.get().mensagem);

                    mensagem.append(String.format(Locale.US, "\nMedia final: %.1f", mediaFinal));

                });

        return mensagem.toString();
    }

    private Double calculaMedia(List<Nota> notas) {
        return somaPonderada(notas, pesos).divide(somaDosPesoss(pesos), 1, RoundingMode.HALF_EVEN).doubleValue();
    }

    private List<Nota> input() {
        return List.of(new Nota(scanner.nextDouble()),
                new Nota(scanner.nextDouble()),
                new Nota(scanner.nextDouble()),
                new Nota(scanner.nextDouble()));

    }

    private BigDecimal somaDosPesoss(List<Double> pesos) {
        return pesos.stream().map(BigDecimal::valueOf).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal somaPonderada(List<Nota> notas, List<Double> pesos) {
        return IntStream.range(0, notas.size())
                .mapToObj(indice -> BigDecimal.valueOf(notas.get(indice).valor())
                        .multiply(BigDecimal.valueOf(pesos.get(indice))))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private record RegraDeIntervalo(Predicate<Double> predicate, String mensagem) {
    }

    private record Nota(Double valor) {
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
