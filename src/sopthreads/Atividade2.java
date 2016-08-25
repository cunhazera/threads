/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopthreads;

import java.util.Scanner;

/**
 * @author UDESC
 */
public class Atividade2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite o número de linhas e colunas da matriz: ");
		int n = teclado.nextInt();

		int matrizA[][] = new int[n][n];
		int matrizB[][] = new int[n][n];
		int matrizR[][] = new int[n][n];

		System.out.println("\n\nDigite os valores da primeira matriz:");
		recebeMatriz(matrizA, n, teclado);

		System.out.println("Digite os valores da primeira matriz:");
		recebeMatriz(matrizB, n, teclado);

		System.out.println("Calculando a matriz Resultante: ");
		/////////////////////////////////////////////////////////////////
		long inicio = System.currentTimeMillis();
		multiplicacao(matrizA, matrizB, matrizR, n);
		long tempo = System.currentTimeMillis() - inicio;
		/////////////////////////////////////////////////////////////////
		System.out.println("A multiplicacao demorou: " + tempo + " milisegundos");
		mostraMatriz(matrizR, n);
	}

	public static void recebeMatriz(int matriz[][], int n, Scanner teclado) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matriz[i][j] = teclado.nextInt();
			}
		}
	}

	public static void multiplicacao(int a[][], int b[][], int c[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				c[i][j] = 0;
				for (int k = 0; k < n; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
	}

	public static void mostraMatriz(int matriz[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
