package threads3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("resource")
public class ReadFiles implements Runnable {

	private File file;
	private double totalVendas;
	private double totalCompras;

	public ReadFiles(File file) {
		this.file = file;
	}

	@Override
	public void run() {
		String thisLine;

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((thisLine = br.readLine()) != null) {
				if (thisLine.startsWith("v")) {
					Double value = Double.valueOf(thisLine.substring(2, thisLine.length()));
					totalVendas += value;
				} else {
					Double value = Double.valueOf(thisLine.substring(2, thisLine.length()));
					totalCompras += value;
				}
			}
		} catch (IOException e) {
			System.err.println("Error: " + e);
		}
	}

	public double getTotalVendas() {
		return totalVendas;
	}

	public double getTotalCompras() {
		return totalCompras;
	}

}
