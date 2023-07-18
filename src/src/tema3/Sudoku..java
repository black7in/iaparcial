/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class Sudoku {
    public static long contador = 0;

    public static void main(String[] args) {
        //int m[][] = new int[9][9];
        int m[][] = {{6, 0, 0, 0, 9, 3, 0, 0, 0},
                     {3, 5, 7, 0, 2, 1, 0, 8, 4},
                     {0, 9, 4, 0, 8, 7, 3, 6, 1},
                     {5, 0, 0, 0, 0, 4, 0, 0, 0},
                     {0, 7, 0, 8, 0, 0, 2, 0, 3},
                     {0, 0, 0, 7, 0, 6, 0, 4, 9},
                     {0, 4, 2, 0, 0, 8, 0, 0, 0},
                     {8, 0, 5, 0, 0, 0, 4, 0, 6},
                     {0, 0, 0, 3, 0, 0, 0, 2, 0}
        };
        //ingresar valores
        mostrar(m);
        if (sudoku(m, 0, 0)) {
            System.out.println("Tiene Solución");
        } else {
            System.out.println("No tiene Solución");
        }
        mostrar(m);
        System.out.println("Vueltas: " + contador);
    }

    public static boolean sudoku(int m[][], int i, int j) {
        if (i >= m.length) {
            return true;
        }
        if (j >= m[i].length) {
            return sudoku(m, i + 1, 0);
        }
        if (m[i][j] != 0) {
            return sudoku(m, i, j + 1);
        }

        LinkedList<Integer> L1 = reglasAplicables(m, i, j);
        System.out.println(L1);
        while (!L1.isEmpty()) {
            m[i][j] = L1.removeFirst();
            System.out.println("Fila: " + i);
            mostrar(m);
            if (sudoku(m, i, j + 1)) {
                return true;
            }
            contador++;
            System.out.println("Fallo");
            m[i][j] = 0;
        }
        return false;
    }

    public static LinkedList<Integer> reglasAplicables(int m[][], int i, int j) {
        LinkedList<Integer> L1 = new LinkedList();
        for (int valor = 1; valor <= m.length; valor++) {
            if (!enFila(m, i, valor) && !enColumna(m, j, valor) && !enRegion(m, i, j, valor)) {
                L1.add(valor);
            }
        }
        return L1;
    }

    public static boolean enFila(int m[][], int i, int valor) {
        for (int j = 0; j < m[i].length; j++) {
            if (m[i][j] == valor) {
                return true;
            }
        }
        return false;
    }

    public static boolean enColumna(int m[][], int j, int valor) {
        for (int i = 0; i < m.length; i++) {
            if (m[i][j] == valor) {
                return true;
            }
        }
        return false;
    }

    public static boolean enRegion(int m[][], int i, int j, int valor) {
        int nFil = (int) Math.sqrt(m.length);
        int nCol = (int) Math.sqrt(m[i].length);

        int iRegion = (i / nFil) * nFil;
        int jRegion = (j / nCol) * nCol;

        for (int a = iRegion; a < iRegion + nFil; a++) {
            for (int b = jRegion; b < jRegion + nCol; b++) {
                if (m[a][b] == valor) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void mostrar(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(" " + m[i][j]);
            }
            System.out.println("");
        }
    }
}
