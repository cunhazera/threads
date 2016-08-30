package threads3;

import java.io.File;

public class Main {

	private static double totalCompras;
	private static double totalVendas;
	private static double balanco;

	public static void main(String[] args) throws InterruptedException {

		File dir = new File("arquivos");

		File[] files = dir.listFiles();
		ReadFiles[] readFile = new ReadFiles[files.length];
		Thread[] threads = new Thread[files.length];

		for (int i = 0; i < files.length; i++) {
			readFile[i] = new ReadFiles(files[i]);
			threads[i] = new Thread(readFile[i]);
		}

		for (Thread thread : threads) {
			thread.start();
		}

		for (Thread thread : threads) {
			thread.join();
		}

		System.out.println(totalCompras);
		System.out.println(totalVendas);
		balanco = totalVendas - totalCompras;
		System.out.println(balanco);

	}

	public static double getTotalCompras() {
		return totalCompras;
	}

	public static void setTotalCompras(double totalCompras) {
		Main.totalCompras = totalCompras;
	}

	public static synchronized double getTotalVendas() {
		return totalVendas;
	}

	public static synchronized void setTotalVendas(double totalVendas) {
		Main.totalVendas = totalVendas;
	}

	public synchronized static double getBalanco() {
		return balanco;
	}

	public synchronized static void setBalanco(double balanco) {
		Main.balanco = balanco;
	}

}
