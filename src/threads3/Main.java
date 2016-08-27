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

		for (int i = 0; i < readFile.length; i++) {
			totalCompras += readFile[i].getTotalCompras();
			totalVendas += readFile[i].getTotalVendas();
			balanco = totalVendas - totalCompras;
		}
		
		System.out.println(totalCompras);
		System.out.println(totalVendas);
		System.out.println(balanco);

	}

}
