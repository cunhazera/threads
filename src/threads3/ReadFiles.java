package threads3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("resource")
public class ReadFiles implements Runnable {

	private File file;

	public ReadFiles(File file) {
		this.file = file;
	}

	@Override
	public void run() {
		String line;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				if (line.startsWith("v")) {
					Double value = Double.valueOf(line.substring(2, line.length()));
					Main.setTotalVendas(Main.getTotalVendas() + value);;
				} else {
					Double value = Double.valueOf(line.substring(2, line.length()));
					Main.setTotalCompras(Main.getTotalCompras() + value);
				}
			}
		} catch (IOException e) {
			System.err.println("Error: " + e);
		}
	}

}
