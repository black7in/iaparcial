/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundoparcial;

import java.util.LinkedList;
import static segundoparcial.Segundoparcial.c;

/**
 *
 * @author HP
 */
public class Laberinto {

    public static void laberinto(int m[][], int i, int j, int i1, int j1,
            int paso) {
        m[i][j] = paso;
        if (i == i1 && j == j1) {
            mostrar(m);
            c++;
        }
        LinkedList<Regla> L1 = reglasAplicablesCaballo(m, i, j);

        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1, m, i1, j1);
            m[R.fil][R.col] = paso;
            laberinto(m, R.fil, R.col, i1, j1, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

    public static Regla elegirRegla(LinkedList<Regla> L1, int m[][], int i1, int j1) {
        return L1.removeFirst();
    }

    public static boolean posValida(int m[][], int i, int j) {
        return i >= 0 && i < m.length && j >= 0 && j < m[i].length
                && m[i][j] == 0;
    }

    public static LinkedList<Regla> reglasAplicablesCaballo(int m[][], int i, int j) {
        LinkedList<Regla> L1 = new LinkedList();
        if (posValida(m, i - 1, j - 2)) {
            L1.add(new Regla(i - 1, j - 2));
        }
        if (posValida(m, i - 2, j - 1)) {
            L1.add(new Regla(i - 2, j - 1));
        }
        if (posValida(m, i - 2, j + 1)) {
            L1.add(new Regla(i - 2, j + 1));
        }
        if (posValida(m, i - 1, j + 2)) {
            L1.add(new Regla(i - 1, j + 2));
        }
        if (posValida(m, i + 1, j + 2)) {
            L1.add(new Regla(i + 1, j + 2));
        }
        if (posValida(m, i + 2, j + 1)) {
            L1.add(new Regla(i + 2, j + 1));
        }
        if (posValida(m, i + 2, j - 1)) {
            L1.add(new Regla(i + 2, j - 1));
        }
        if (posValida(m, i + 1, j - 2)) {
            L1.add(new Regla(i + 1, j - 2));
        }
        return L1;
    }

    public static LinkedList<Regla> reglasAplicablesTorre(int m[][], int i, int j) {
        LinkedList<Regla> L1 = new LinkedList<>();

        // Movimiento horizontal hacia la izquierda
        for (int k = j - 1; k >= 0; k--) {
            if (posValida(m, i, k)) {
                L1.add(new Regla(i, k));
            } else {
                break;
            }
        }

        // Movimiento horizontal hacia la derecha
        for (int k = j + 1; k < m[i].length; k++) {
            if (posValida(m, i, k)) {
                L1.add(new Regla(i, k));
            } else {
                break;
            }
        }

        // Movimiento vertical hacia arriba
        for (int k = i - 1; k >= 0; k--) {
            if (posValida(m, k, j)) {
                L1.add(new Regla(k, j));
            } else {
                break;
            }
        }

        // Movimiento vertical hacia abajo
        for (int k = i + 1; k < m.length; k++) {
            if (posValida(m, k, j)) {
                L1.add(new Regla(k, j));
            } else {
                break;
            }
        }
        return L1;
    }

    public static LinkedList<Regla> reglasAplicablesAlfil(int m[][], int i, int j) {
        LinkedList<Regla> L1 = new LinkedList<>();

        // Movimiento en diagonal superior izquierdo
        for (int k = 1; posValida(m, i - k, j - k); k++) {
            L1.add(new Regla(i - k, j - k));
        }

        // Movimiento en diagonal superior derecho
        for (int k = 1; posValida(m, i - k, j + k); k++) {
            L1.add(new Regla(i - k, j + k));
        }

        // Movimiento en diagonal inferior izquierdo
        for (int k = 1; posValida(m, i + k, j - k); k++) {
            L1.add(new Regla(i + k, j - k));
        }

        // Movimiento en diagonal inferior derecho
        for (int k = 1; posValida(m, i + k, j + k); k++) {
            L1.add(new Regla(i + k, j + k));
        }

        return L1;
    }

    public static LinkedList<Regla> reglasAplicablesReina(int m[][], int i, int j) {
        LinkedList<Regla> L1 = new LinkedList<>();

        // Movimiento horizontal y vertical
        for (int k = 0; k < m.length; k++) {
            if (k != i) {
                L1.add(new Regla(k, j)); // Movimiento vertical
            }
            if (k != j) {
                L1.add(new Regla(i, k)); // Movimiento horizontal
            }
        }

        // Movimiento diagonal
        for (int k = 1; k < m.length; k++) {
            if (posValida(m, i - k, j - k)) {
                L1.add(new Regla(i - k, j - k)); // Movimiento diagonal superior izquierdo
            }
            if (posValida(m, i - k, j + k)) {
                L1.add(new Regla(i - k, j + k)); // Movimiento diagonal superior derecho
            }
            if (posValida(m, i + k, j - k)) {
                L1.add(new Regla(i + k, j - k)); // Movimiento diagonal inferior izquierdo
            }
            if (posValida(m, i + k, j + k)) {
                L1.add(new Regla(i + k, j + k)); // Movimiento diagonal inferior derecho
            }
        }

        return L1;
    }

    public static void mostrar(int m[][]) {
        for (int[] m1 : m) {
            for (int j = 0; j < m1.length; j++) {
                System.out.print(m1[j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
