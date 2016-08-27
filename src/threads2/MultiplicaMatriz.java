package threads2;

public class MultiplicaMatriz implements Runnable {

	private int inicio;
	private int fim;
	private int n;
	private int[][] c;
	private int[][] a;
	private int[][] b;
	
	public MultiplicaMatriz(int inicio, int fim, int n, int[][] a, int[][] b, int[][] c) {
		this.inicio = inicio;
		this.fim = fim;
		this.n = n;
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public void run() {
		for (int i = inicio; i < fim; i++) {
			for (int j = 0; j < n; j++) {
				c[i][j] = 0;
				for (int k = 0; k < n; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
	}

}
