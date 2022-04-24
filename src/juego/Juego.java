package juego;

/**
 * Clase juego para el proyecto de de programación Juego de la Vida
 * 
 * @author Marina López y Zoe Santoalla
 *
 */

public class Juego {
	// Propiedades
	private final int VIVA = 1;
	private final int MUERTA = 0;
	private final int DIMENSION = 50;
	private int tablero1[][];
	private int tablero2[][];

	// Constructor
	public Juego(int[][] tablero1) {
		try {
			crearTablero1(tablero1);
			this.tablero2 = new int[DIMENSION][DIMENSION];
			crearTablero2();
		} catch (Exception e) {
			throw e;
		}
	}

	// Getters y Setter
	public int[][] getTablero1() {
		return this.tablero1;
	}

	/**
	 * Método que crea el primer tablero a partir del array que introducimos como
	 * parametro. Ajusta el tamaño del tablero a la propiedad DIMENSION. Si el
	 * tamaño original es mayor que DIMENSION lanza una excepcion.
	 * 
	 * @param tablero1
	 */
	public void crearTablero1(int[][] tablero1) {
		if (tablero1.length < DIMENSION) {
			int nuevaMatriz[][] = new int[DIMENSION][DIMENSION];
			int resta = (DIMENSION - tablero1.length) / 2;
			for (int i = 0; i < nuevaMatriz.length; i++) {
				for (int j = 0; j < nuevaMatriz[i].length; j++) {

					if (i < resta || i >= tablero1.length + resta) {
						nuevaMatriz[i][j] = MUERTA;
					} else if ((i >= resta && j < resta) || (i >= resta && j >= tablero1.length + resta)) {
						nuevaMatriz[i][j] = MUERTA;
					} else if (i >= resta && j >= resta && j < tablero1.length + resta) {
						nuevaMatriz[i][j] = tablero1[i - resta][j - resta];
					}

				}

			}
			tablero1 = nuevaMatriz;

		} else if (tablero1.length > DIMENSION) {
			throw new IllegalArgumentException("No se puede jugar con una matriz mayor a " + DIMENSION);
		}

		this.tablero1 = tablero1;
	}

	public int[][] getTablero2() {
		return tablero2;
	}

	/**
	 * Metodo que recorre tablero1 y asigna los valores correspondientes a tablero2
	 * (siguiente generacion), llamando al metodo vivirOMorir.
	 */
	public void crearTablero2() {

		for (int i = 0; i < tablero1.length; i++) {
			for (int j = 0; j < tablero1[i].length; j++) {
				this.tablero2[i][j] = vivirOMorir(i, j);
			}
		}

	}

	/**
	 * Evalua si una celula debe vivir o morir, y nos devuelve su estado para la
	 * siguiente generacion.
	 * 
	 * @param i, fila de la celula a evaluar
	 * @param j, columna de la celula a evaluar
	 * @return VIVA o MUERTA, estado de la celula para la siguiente generacion.
	 */
	private int vivirOMorir(int i, int j) {

		int contador = 0;
		int startFila = i - 1;
		int endFila = i + 1;
		int startCol = j - 1;
		int endCol = j + 1;

		if (i == 0) {
			startFila = i;
		} else if (i == DIMENSION - 1) {
			endFila = i;
		}

		if (j == 0) {
			startCol = j;
		} else if (j == DIMENSION - 1) {
			endCol = j;
		}

		for (int fila = startFila; fila <= endFila; fila++) {
			for (int col = startCol; col <= endCol; col++) {
				if (fila == i && col == j) {
					continue;
				}
				if (this.tablero1[fila][col] == 1) {
					contador++;
				}
			}
		}

		if (contador > 3 || contador < 2) {
			return MUERTA;
		} else if (contador == 3) {
			return VIVA;
		} else {
			return this.tablero1[i][j];
		}

	}

}
