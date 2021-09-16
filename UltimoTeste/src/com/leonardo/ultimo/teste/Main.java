package com.leonardo.ultimo.teste;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = lerInteiro();
		String valorDigitado;

		while(n-- >0) {

			valorDigitado = lerString();

			List<String> permuta = new ArrayList<>();

			receberPermuta("", valorDigitado, permuta);
			List<String> palavras = new ArrayList<>(permuta);

			comparandoPalavras(palavras);
			palavras = removerCombinacoesIguais(palavras);
			listarPalavras(palavras);
			System.out.println();
		}
	}

	private static String lerString() throws IOException {
		return sc.nextLine();
	}

	private static int lerInteiro() throws IOException {
		return Integer.parseInt(sc.nextLine());
	}


	private static List<String> receberPermuta(String caracter, String valorDigitado, List<String> lista){
		int n = valorDigitado.length();
		if(n ==0) {
			lista.add(caracter);
		}else {
			for(int i =0; i< n;i++) {

				receberPermuta(
						caracter + valorDigitado.charAt(i),
						valorDigitado.substring(0,i) + valorDigitado.substring(i + 1, n),
						lista
						);
			}
		}
		return lista;
	}

	public static List<String> listarPalavras(List<String> palavras){
		for(String texto : palavras) {
			if(!texto.isEmpty()) {
				System.out.println(texto);
			}
		}

		return palavras;
	}

	private static List<String> comparandoPalavras(List<String> palavras) {
		palavras.sort(Comparator.naturalOrder());
		return palavras;
	}

	private static List<String> removerCombinacoesIguais(List<String> palavras) {
		return palavras.stream().distinct().collect(Collectors.toList());
	}
}
