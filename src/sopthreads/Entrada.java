/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopthreads;

import java.util.Random;

public class Entrada {

	private static int n = 10;
	private static int MAX_VAL = 50;

	public static void main(String args[]) {
		System.out.println(n);
		Random rnd = new Random();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(rnd.nextInt(MAX_VAL) + " ");
			}
			System.out.println("");
		}

		// pular uma linha para distinguir as matrizes
		System.out.println("");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(rnd.nextInt(MAX_VAL) + " ");
			}
			System.out.println("");
		}
	}
}
