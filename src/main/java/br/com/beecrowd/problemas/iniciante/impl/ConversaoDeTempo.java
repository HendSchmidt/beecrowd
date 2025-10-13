package br.com.beecrowd.problemas.iniciante.impl;

import java.time.Duration;
import java.util.Scanner;

import br.com.beecrowd.problemas.iniciante.Executavel;

public class ConversaoDeTempo implements Executavel {

    @Override
    public String execute() {
        return retornaMensagem(converteSegundoEmHoras(input()));
    }

    private static String retornaMensagem(Duration time) {
        return String.format("%d:%d:%d", time.toHours(), time.toMinutesPart(), time.toSecondsPart());
    }

    private Duration converteSegundoEmHoras(Long segundos) {
    
        return Duration.ofSeconds(segundos);
    }

    private Long input() {
        try (Scanner in = new Scanner(System.in)) {
            return in.nextLong();
        }
    }
}
