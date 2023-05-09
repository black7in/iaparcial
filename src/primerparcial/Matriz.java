/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author HP
 */
public class Matriz {
    int elem[][];
    private int cantFil;
    private int cantCol;
    private int maxFil;
    private int maxCol;

    public Matriz(int[][] elem, int cantFil, int cantCol, int maxFil, int maxCol) {
        this.elem = elem;
        this.cantFil = cantFil;
        this.cantCol = cantCol;
        this.maxFil = maxFil;
        this.maxCol = maxCol;
    }
    
    public Matriz(Matriz M) {
        this.elem = M.elem;
        this.cantCol = M.cantCol;
        this.cantFil = M.cantFil;
        this.maxCol = M.maxCol;
        this.maxFil = M.maxFil;
    }

    public int getCantFil() {
        return cantFil;
    }

    public void setCantFil(int cantFil) {
        this.cantFil = cantFil;
    }

    public int getCantCol() {
        return cantCol;
    }

    public void setCantCol(int cantCol) {
        this.cantCol = cantCol;
    }

    public int getMaxFil() {
        return maxFil;
    }

    public void setMaxFil(int maxFil) {
        this.maxFil = maxFil;
    }

    public int getMaxCol() {
        return maxCol;
    }

    public void setMaxCol(int maxCol) {
        this.maxCol = maxCol;
    }

    int getElem(int i, int j) {
        return elem[i][j];
    }

    int signo(int i, int j) {
        return (i + j) % 2 == 0 ? 1 : -1;
    }

    void eliminarFila(int i) {
        int nuevaMatriz[][] = new int[getMaxFil()][getMaxCol()];
        int filaActual = 0;
        for (int k = 0; k < getCantFil(); k++) {
            if (i != k) {
                nuevaMatriz[filaActual] = elem[k];
                filaActual++;
            }
        }
        setCantFil(getCantFil() - 1);
        elem = nuevaMatriz;
    }

    // 3. Implementar M1.eliminarCol(j), idem al anterior, solo respecto a la fila.
    void eliminarCol(int j) {
        int nuevaMatriz[][] = new int[getMaxFil()][getMaxCol()];
        for (int i = 0; i < getCantFil(); i++) {
            int columnaActual = 0;
            for (int k = 0; k < getCantCol(); k++) {
                if (j != k) {
                    nuevaMatriz[i][columnaActual] = elem[i][k];
                    columnaActual++;
                }
            }
        }
        setCantCol(getCantCol() - 1);
        elem = nuevaMatriz;
    }

    //M1.generar(n, m, a, b) : Método que genera n x m elementos aleatorios entre a y b, inclusive en la matriz M1.
    void generar(int n, int m, int a, int b) {
        Random rand = new Random();
        setCantFil(n);
        setCantCol(m);
        for (int i = 0; i < getCantFil(); i++) {
            for (int j = 0; j < getCantCol(); j++) {
                int numeroAleatorio = rand.nextInt(b - a + 1) + a;
                elem[i][j] = numeroAleatorio;
            }
        }
    }

    //5. M1.listaFil(i) : Método que devuelve en una Lista, los elementos de la fila i, de la matriz M1.
    LinkedList<Integer> listaFil(int i) {
        LinkedList<Integer> listaDeFilas;
        listaDeFilas = new LinkedList<>();
        for (int j = 0; j < getCantCol(); j++) {
            listaDeFilas.add(elem[i][j]);
        }
        return listaDeFilas;
    }

    /*
    6. M1.listaCol(j): Método que devuelve en una Lista, los elementos de la columna j, de la matriz M1. 
     */
    LinkedList<Integer> listaCol(int j) {
        LinkedList<Integer> listaDeColumnas;
        listaDeColumnas = new LinkedList<>();
        for (int i = 0; i < getCantFil(); i++) {
            listaDeColumnas.add(elem[i][j]);
        }
        return listaDeColumnas;
    }

    /*
    7. M1.insertarFil(i, L1) : Método que insertar los elementos de la lista L1, en la fila i, de la matriz M1.
     */
    void insertarFil(int i, LinkedList<Integer> L1) {
        for (int j = 0; j < L1.size(); j++) {
            elem[i][j] = L1.get(j);
        }

        if (i >= getCantFil()) {
            setCantFil(getCantFil() + 1);
        }

        if (L1.size() >= getCantCol()) {
            setCantCol(L1.size());
        }
    }

    /*
    8. M1.insertarCol(i, L1) : Método que insertar los elementos de la lista L1, en la columna j, de la matriz M1.
     */
    void insertarCol(int j, LinkedList<Integer> L1) {
        for (int i = 0; i < L1.size(); i++) {
            elem[i][j] = L1.get(i);
        }

        if (j >= getCantCol()) {
            setCantCol(getCantCol() + 1);
        }

        if (L1.size() >= getCantFil()) {
            setCantFil(L1.size());
        }
    }

    /*
    9. M1.menor(i, j) : Método que devuelve una matriz nueva, resultado de eliminar la fila i y la columna j de la matriz M1.
     */
    Matriz menor(int i, int j) {
        Matriz nuevaMatriz = new Matriz(this);
        nuevaMatriz.eliminarFila(i);
        nuevaMatriz.eliminarCol(j);
        return nuevaMatriz;
    }

    /*
    10. M1.determinante() : Método que encuentra el determinante de la matriz cuadrada M1. 
    Utilizar la estructura de código de llamada recursiva dentro de un ciclo.
     */
    int determinante() {
        if (getCantCol() == 1) {
            return getElem(0, 0);
        }

        int suma = 0;
        int j = 0;
        int i = 0;
        while (i < getCantCol()) {
            suma += signo(i, j) * getElem(i, j) * determinante(menor(i, j));
            i++;
        }
        return suma;
    }

    private int determinante(Matriz matriz) {
        return matriz.determinante();
    }

    public void imprimir() {
        for (int i = 0; i < getCantFil(); i++) {
            for (int j = 0; j < getCantCol(); j++) {
                System.out.print(elem[i][j] + " ");
            }
            System.out.println();
        }
    }
}
