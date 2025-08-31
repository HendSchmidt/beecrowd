package br.com.beecrowd.problemas.iniciante;

import java.util.Scanner;

public class ExtremamenteBasico {
	public String retornaMensagem(){
		return "X = " + somaInputs();
	}
	public int somaInputs(){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		return soma(a,b);
	}

	public int soma(int a, int b) {
		return a + b;
	}
}
