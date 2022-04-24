package juego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utilidades {

	private static final String SEPARADOR = ",";

	public static int[][] leerFichero(String ruta) {

		int[][] valores;
		int[] valores_fila;
		String linea;
		String[] elementos;

		try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {

			ArrayList<String> lineas = new ArrayList<>();
			// leemos primera línea
			linea = lector.readLine();
			while (linea != null) {
				// agregamos a la lista y leemos la siguiente línea
				lineas.add(linea.trim());
				linea = lector.readLine();
			} // fin del recorrido del fichero

			/*
			 * ahora sabemos cuántas líneas tenemos, que coincide con las filas de la matriz
			 * La segunda dimensión la dejamos sin definir
			 */
			valores = new int[lineas.size()][];

			int n_fila = 0;

			for (String fila : lineas) {
				// separo los valores de la fila leída
				elementos = fila.split(SEPARADOR);

				// ahora podemos dimensionar esta fila
				valores_fila = new int[elementos.length];
				for (int k = 0; k < elementos.length; k++) {
					valores_fila[k] = Integer.parseInt(elementos[k]);
				}
				// y agrego la fila en la posición correspondiente
				valores[n_fila] = valores_fila;
				n_fila++; // incremento el contador de la fila
			}
			return valores;

		} catch (IOException e) {
			System.out.println("Se produjo el siguiente error al acceder al fichero \n " + e.getMessage());
			return null;
		} catch (NumberFormatException e) {
			System.out.println("Revise el fichero porque tiene valores que no pueden convertirse a enteros");
			return null;
		}

	}

	public static void mostrarMatriz(int[][] matriz) {
		// imprimo los valores leídos
		for (int i = 0; i < matriz.length; i++) {
			try {
				Thread.sleep(0010);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int k = 0; k < matriz[i].length; k++) {
				if (matriz[i][k] == 0) {
					System.out.print(" ");
				} else {
					System.out.print(matriz[i][k]);
				}
			}
			System.out.println(); // retorno de carro adicional

		}
	}

}
