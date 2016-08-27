/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads2;

import java.util.Scanner;

/**
 * @author UDESC
 */
public class Atividade2 {

	static int threads;

	public static void main(String[] args) throws InterruptedException {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite o número de threads: ");
		threads = teclado.nextInt();
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
		mostraMatriz(matrizR, n);
		System.out.println("A multiplicacao demorou: " + tempo + " milisegundos");
	}

	public static void multiplicacao(int a[][], int b[][], int c[][], int n) throws InterruptedException {

		if (threads == 1) {
			int inicioT1 = 0;
			int fimT1 = n;
			MultiplicaMatriz mult = new MultiplicaMatriz(inicioT1, fimT1, n, a, b, c);
			Thread oneThread = new Thread(mult);
			oneThread.start();
		}

		if (threads == 2) {
			int inicioThreadUm = 0;
			int fimThreadUm = n / threads;
			int inicioThreadDois = fimThreadUm + 1;
			int fimThreadDois = n;

			MultiplicaMatriz mult1 = new MultiplicaMatriz(inicioThreadUm, fimThreadUm, n, a, b, c);
			MultiplicaMatriz mult2 = new MultiplicaMatriz(inicioThreadDois, fimThreadDois, n, a, b, c);
			Thread threadOne = new Thread(mult1);
			Thread threadTwo = new Thread(mult2);

			threadOne.start();
			threadTwo.start();

			threadOne.join();
		}

		if (threads == 3) {
			int inicioThreadUm = 0;
			int fimThreadUm = n / threads;
			int inicioThreadDois = fimThreadUm + 1;
			int fimThreadDois = n;
			int inicioThreadTres = fimThreadDois + 1;
			int fimThreadTres = n;

			MultiplicaMatriz mult1 = new MultiplicaMatriz(inicioThreadUm, fimThreadUm, n, a, b, c);
			MultiplicaMatriz mult2 = new MultiplicaMatriz(inicioThreadDois, fimThreadDois, n, a, b, c);
			MultiplicaMatriz mult3 = new MultiplicaMatriz(inicioThreadTres, fimThreadTres, n, a, b, c);
			Thread threadOne = new Thread(mult1);
			Thread threadTwo = new Thread(mult2);
			Thread threadThree = new Thread(mult3);

			threadOne.start();
			threadTwo.start();
			threadThree.start();

			threadOne.join();
			threadTwo.join();
		}

		if (threads == 4) {
			int inicioThreadUm = 0;
			int fimThreadUm = n / threads;
			int inicioThreadDois = fimThreadUm + 1;
			int fimThreadDois = n;
			int inicioThreadTres = fimThreadDois + 1;
			int fimThreadTres = inicioThreadTres + fimThreadUm;
			int inicioThreadQuatro = fimThreadTres + 1;
			int fimThreadQuatro = n;

			MultiplicaMatriz mult1 = new MultiplicaMatriz(inicioThreadUm, fimThreadUm, n, a, b, c);
			MultiplicaMatriz mult2 = new MultiplicaMatriz(inicioThreadDois, fimThreadDois, n, a, b, c);
			MultiplicaMatriz mult3 = new MultiplicaMatriz(inicioThreadTres, fimThreadTres, n, a, b, c);
			MultiplicaMatriz mult4 = new MultiplicaMatriz(inicioThreadQuatro, fimThreadQuatro, n, a, b, c);
			Thread threadOne = new Thread(mult1);
			Thread threadTwo = new Thread(mult2);
			Thread threadThree = new Thread(mult3);
			Thread threadFour = new Thread(mult4);

			threadOne.start();
			threadTwo.start();
			threadThree.start();
			threadFour.start();

			threadOne.join();
			threadTwo.join();
		}

	}

	public static void recebeMatriz(int matriz[][], int n, Scanner teclado) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matriz[i][j] = teclado.nextInt();
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
