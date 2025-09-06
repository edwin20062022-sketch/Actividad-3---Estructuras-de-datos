public class Sudoku {
    private static final int N = 9; // Tamaño del tablero
    public static void main(String[] args) {
        int[][] tablero = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(tablero)) {
            System.out.println("Sudoku resuelto:");
            mostrarTablero(tablero);
        } else {
            System.out.println("Este Sudoku no tiene solución.");
        }
    }

    // Algoritmo de backtracking
    public static boolean solveSudoku(int[][] tablero) {
        for (int fila = 0; fila < N; fila++) {
            for (int col = 0; col < N; col++) {
                if (tablero[fila][col] == 0) { // Encontrar celda vacía
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(tablero, fila, col, num)) {
                            tablero[fila][col] = num; // Colocar número

                            if (solveSudoku(tablero)) {
                                return true;
                            }

                            tablero[fila][col] = 0; // Backtrack
                        }
                    }
                    return false; // Si ningún número es válido
                }
            }
        }
        return true; // Tablero lleno
    }

    // Verifica si colocar un número es válido
    private static boolean isValid(int[][] tablero, int fila, int col, int num) {
        // Verificar fila y columna
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == num || tablero[i][col] == num) {
                return false;
            }
        }

        // Verificar subcuadro 3x3
        int iniciarFila = fila - fila % 3;
        int iniciarColumna = col - col % 3;

        for (int i = iniciarFila; i < iniciarFila + 3; i++) {
            for (int j = iniciarColumna; j < iniciarColumna + 3; j++) {
                if (tablero[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Imprime el tablero
    private static void mostrarTablero(int[][] tablero) {
        for (int f = 0; f < N; f++) {
            if (f % 3 == 0 && f != 0) {
                System.out.println("----------+-----------+-----------");
            }
            for (int c = 0; c < N; c++) {
                if (c % 3 == 0 && c != 0) {
                    System.out.print(" | ");
                }
                System.out.print(" " + tablero[f][c] + " ");
            }
            System.out.println();
        }
    }
}
