/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema3;

import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class Tema3 {

    /**
     */
    public static long c = 0;

    public static void main(String[] args) {
        // TODO code application logic here

        int n = 4;
        int m[][] = new int[n][n];
        if (nReinas(m, 0)) {
            System.out.println("Existe Solución");
            System.out.println("Cantidad de Vueltas: " + c);
        } else {
            System.out.println("No Existe Solución");
            System.out.println("Cantidad de Vueltas: " + c);
        }
    }

    public static boolean diagSupDer(int m[][], int i1, int j1) {
        int i = i1, j = j1;
        while (i >= 0 && j < m[i1].length) {
            if (m[i][j] != 0) {
                return false;
            }
            i = i - 1;
            j = j + 1;
        }
        return true;
    }

    public static boolean diagSupIzq(int m[][], int i1, int j1) {
        int i = i1, j = j1;
        while (i >= 0 && j >= 0) {
            if (m[i][j] != 0) {
                return false;
            }
            i = i - 1;
            j = j - 1;
        }
        return true;
    }

    public static boolean diagInfIzq(int m[][], int i1, int j1) {
        int i = i1, j = j1;
        while (i < m.length && j >= 0) {
            if (m[i][j] != 0) {
                return false;
            }
            i = i + 1;
            j = j - 1;
        }
        return true;
    }

    public static boolean diagInfDer(int m[][], int i1, int j1) {
        int i = i1, j = j1;
        while (i < m.length && j < m[i].length) {
            if (m[i][j] != 0) {
                return false;
            }
            i = i + 1;
            j = j + 1;
        }
        return true;
    }

    public static boolean filValido(int m[][], int i) {
        int j = 0;
        while (j < m[i].length) {
            if (m[i][j] != 0) {
                return false;
            }
            j++;
        }

        return true;
    }

    public static boolean colValido(int m[][], int j) {
        int i = 0;
        while (i < m.length) {
            if (m[i][j] != 0) {
                return false;
            }
            i++;
        }

        return true;
    }

    public static boolean posValido(int m[][], int i, int j) {
        return filValido(m, i) && colValido(m, j)
                && diagSupIzq(m, i, j) && diagSupDer(m, i, j)
                && diagInfIzq(m, i, j) && diagInfDer(m, i, j);
    }

    // Sin heurística...
    public static Regla elegirReglaA(LinkedList<Regla> L1) {
        return L1.removeFirst();
    }

    // Con heurística...
    public static Regla elegirReglaB(LinkedList<Regla> L1) {
        return L1.remove(L1.size() / 2);
    }

    public static LinkedList<Regla> reglasAplicables(int m[][], int i) {
        LinkedList<Regla> L1 = new LinkedList();
        for (int j = 0; j < m[i].length; j++) {
            if (posValido(m, i, j)) {
                L1.add(new Regla(i, j));
            }
        }
        return L1;
    }

    public static boolean nReinas(int m[][], int i) {
        if (i >= m.length) {
            return true;
        }
        LinkedList L1 = reglasAplicables(m, i);
        while (!L1.isEmpty()) {
            Regla R = elegirReglaA(L1);
            m[R.fil][R.col] = i + 1;
            if (nReinas(m, i + 1)) {
                return true;
            }
            m[R.fil][R.col] = 0;
            c++;
        }
        return false;
    }

}
