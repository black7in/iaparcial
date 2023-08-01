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

        int n = 5;
        int m[][] = new int[n][n];
        /*if (nReinas(m, 0)) {
            System.out.println("Existe Solución");
            imprimir(m);
        } else {
            System.out.println("No Existe Solución");
        }*/

        if (laberintoRey(m, 0, 0, n - 1, n - 1, 1)) {
            System.out.println("Existe Solución");
            imprimir(m);
        } else {
            System.out.println("No Existe Solución");
        }

        System.out.println("Cantidad de Vueltas: " + c);
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

    public static boolean posValida(int m[][], int i, int j) {
        return i >= 0 && i < m.length && j >= 0 && j < m[i].length
                && m[i][j] == 0;
    }

    // Sin heurística...
    public static Regla elegirReglaA(LinkedList<Regla> L1) {
        return L1.removeFirst();
    }

    // Con heurística...
    public static Regla elegirReglaB(LinkedList<Regla> L1) {
        return L1.remove(L1.size() / 2);
    }

    // heuristica aleatoria
    public static Regla elegirReglaC(LinkedList<Regla> L1) {
        return L1.remove((int) (Math.random() * L1.size()));
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

    public static LinkedList<Regla> reglasAplicablesRey(int m[][], int i, int j) {
        LinkedList<Regla> L1 = new LinkedList<>();

        // Movimiento hacia la izquierda superior
        if (posValida(m, i - 1, j - 1)) {
            L1.add(new Regla(i - 1, j - 1));
        }

        // Movimiento hacia arriba
        if (posValida(m, i - 1, j)) {
            L1.add(new Regla(i - 1, j));
        }

        // Movimiento hacia la derecha superior
        if (posValida(m, i - 1, j + 1)) {
            L1.add(new Regla(i - 1, j + 1));
        }

        // Movimiento hacia la izquierda
        if (posValida(m, i, j - 1)) {
            L1.add(new Regla(i, j - 1));
        }

        // Movimiento hacia la derecha
        if (posValida(m, i, j + 1)) {
            L1.add(new Regla(i, j + 1));
        }

        // Movimiento hacia la izquierda inferior
        if (posValida(m, i + 1, j - 1)) {
            L1.add(new Regla(i + 1, j - 1));
        }

        // Movimiento hacia abajo
        if (posValida(m, i + 1, j)) {
            L1.add(new Regla(i + 1, j));
        }

        // Movimiento hacia la derecha inferior
        if (posValida(m, i + 1, j + 1)) {
            L1.add(new Regla(i + 1, j + 1));
        }

        return L1;
    }
            
    public static LinkedList<Regla> reglasaplicablescaballo(int m[][], int i, int j) {
        LinkedList<Regla> l1 = new LinkedList();

        if (posValida(m, i - 1, j - 2)) {
            l1.add(new Regla(i - 1, j - 2));
        }

        if (posValida(m, i - 2, j - 1)) {
            l1.add(new Regla(i - 2, j - 1));
        }
        if (posValida(m, i - 2, j + 1)) {
            l1.add(new Regla(i - 2, j + 1));
        }

        if (posValida(m, i - 1, j + 2)) {
            l1.add(new Regla(i - 1, j + 2));
        }
        if (posValida(m, i + 1, j + 2)) {
            l1.add(new Regla(i + 1, j + 2));
        }

        if (posValida(m, i + 2, j + 1)) {
            l1.add(new Regla(i + 2, j + 1));
        }
        if (posValida(m, i + 2, j - 1)) {
            l1.add(new Regla(i + 2, j - 1));
        }

        if (posValida(m, i + 1, j - 2)) {
            l1.add(new Regla(i + 1, j - 2));
        }

        return l1;
    }

    public static boolean nReinas(int m[][], int i) {
        if (i >= m.length) {
            return true;
        }
        LinkedList L1 = reglasAplicables(m, i);
        while (!L1.isEmpty()) {
            Regla R = elegirReglaB(L1);
            m[R.fil][R.col] = i + 1;
            if (nReinas(m, i + 1)) {
                return true;
            }
            m[R.fil][R.col] = 0;
            c++;
        }
        return false;
    }

    public static boolean saltoCaballo(int m[][], int i, int j, int ifin, int jfin, int paso) {
        m[i][j] = paso;
        if (i == ifin && j == jfin && todosVisitados(m)) {
            return true;
        }
        LinkedList<Regla> L1 = reglasaplicablescaballo(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirReglaB(L1);
            if (saltoCaballo(m, R.fil, R.col, ifin, jfin, paso + 1)) {
                return true;
            }
            m[R.fil][R.col] = 0;
            c++;
        }

        return false;
    }

    public static boolean laberintoRey(int m[][], int i, int j, int ifin, int jfin, int paso) {
        m[i][j] = paso;
        if (i == ifin && j == jfin && todosVisitados(m)) {
            return true;
        }
        
        LinkedList<Regla> L1 = reglasAplicablesRey(m, i, j);

        while (!L1.isEmpty()) {
            Regla R = elegirReglaB(L1);
            
            if (laberintoRey(m, R.fil, R.col, ifin, jfin, paso + 1)) {
                return true;
            }
            m[R.fil][R.col] = 0;
            c++;
        }
        
        return false;
    }

    public static boolean todosVisitados(int m[][]) {
        for (int[] m1 : m) {
            for (int j = 0; j < m[0].length; j++) {
                if (m1[j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void imprimir(int m[][]) {
        for (int[] m1 : m) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m1[j] + " ");
            }
            System.out.println();
        }
    }

}
