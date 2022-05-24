package juego;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {

		final String RUTA_LECTURA = "src/ficheros/pruebaJV.txt"; 
		final int MAX_GENERACIONES = 10;
		int generaciones = 1;
		Scanner sc = new Scanner(System.in);
		// archivos .txt

		int[][] valores = Utilidades.leerFichero(RUTA_LECTURA);

		Juego juego1 = new Juego(valores);

		Utilidades.mostrarMatriz(juego1.getTablero1());
		System.out.println("Intro para continuar las generaciones. Max. 10");
		Utilidades.mostrarMatriz(juego1.getTablero2());
		sc.nextLine();
		while (generaciones < MAX_GENERACIONES) {
			juego1.crearTablero1(juego1.getTablero2());
			juego1.crearTablero2();

			System.out.println("Esta es la gerneracion numero " + generaciones);
			Utilidades.mostrarMatriz(juego1.getTablero1());
			System.out.println(" ");
			Utilidades.mostrarMatriz(juego1.getTablero2());
			sc.nextLine();

			generaciones++;

		}

	}

}
