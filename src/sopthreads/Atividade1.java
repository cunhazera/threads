package sopthreads;

import java.util.Scanner;

public class Atividade1 {

	private static int va[];
	private static int vb[];
	public static int vc[];

	public static void main(String[] args) throws InterruptedException {
		int tamanho = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite um tamanho para o vetor Va e Vb");
		tamanho = scanner.nextInt();

		va = new int[tamanho];
		vb = new int[tamanho];
		vc = new int[tamanho];

		for (int i = 0; i < tamanho; i++) {
			va[i] = i + 1;
			vb[i] = i + 1;
		}

		int inicioT1 = 0, fimT1 = tamanho / 4;
		int inicioT2 = fimT1 + 1, fimT2 = inicioT2 + fimT1;
		int inicioT3 = fimT2 + 1, fimT3 = inicioT3 + fimT1;
		int inicioT4 = fimT3 + 1, fimT4 = tamanho;

		if (fimT4 < inicioT4) {
			fimT4 = inicioT4 + 1;
		}

		ThreadSop ThreadSopOne = new ThreadSop(inicioT1, fimT1, va, vb, tamanho);
		ThreadSop ThreadSopTwo = new ThreadSop(inicioT2 - 1, fimT2, va, vb, tamanho);
		ThreadSop ThreadSopThree = new ThreadSop(inicioT3 - 1, fimT3, va, vb, tamanho);
		ThreadSop ThreadSopFour = new ThreadSop(inicioT4 - 1, fimT4, va, vb, tamanho);

		Thread thr1 = new Thread(ThreadSopOne);
		Thread thr2 = new Thread(ThreadSopTwo);
		Thread thr3 = new Thread(ThreadSopThree);
		Thread thr4 = new Thread(ThreadSopFour);

		thr1.start();
		thr2.start();
		thr3.start();
		thr4.start();

		thr1.join();
		thr2.join();
		thr3.join();
		thr4.join();

		for (int i : vc) {
			System.out.println(i);
		}

	}

}

class ThreadSop implements Runnable {

	private static int vetorA[];
	private static int vetorB[];
	private static int vetorC[];
	private int inicio;
	private int fim;

	public ThreadSop(int inicio, int fim, int vetorA[], int vetorB[], int tamanho) {
		this.inicio = inicio;
		this.fim = fim;
		this.vetorA = vetorA;
		this.vetorB = vetorB;
		this.vetorC = new int[fim - inicio];
	}

	@Override
	public void run() {
		for (int i = inicio; i < fim; i++) {
			Atividade1.vc[i] = vetorA[i] + vetorB[i];
		}
	}

}
