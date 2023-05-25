/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laberinto;

/**
 *
 * @author HP
 */
public class Laberinto {

    /**
     */
    
    public static int c = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 3;
        int b = 3;
        int m[][] = new int[a][b];
        
        laberinto(m, 0, 0, a -1, b -1, 1);
        System.out.println("Soluciones: " + c);
    }
    
    public static void laberinto(int m[][], int i, int j, int i1, int j1, int paso){
        if(!posValida(m, i, j)) return;
        m[i][j] = paso;
        
        if( i == i1 && j == j1){mostrar(m); c++;}
        
        laberinto(m, i, j -1, i1, j1, paso +1);
        laberinto(m, i -1, j, i1, j1,  paso + 1);
        laberinto(m, i, j + 1,  i1, j1, paso + 1);
        laberinto(m, i + 1, j,  i1, j1, paso + 1);
        m[i][j] = 0;
    }
    
    public static void mostrar(int m[][]){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    
    }
    public static boolean posValida(int m[][], int i, int j){
        return i >=0 && i < m.length && j >=0 && j < m[i].length && m[i][j] == 0;
    
    }
    
    
    public static void laberintoA(int m[][], int i, int j, int paso){
        if(!posValida(m, i, j)) return;
        m[i][j] = paso;
        mostrar(m);
        laberintoA(m, i, j - 1, paso + 1);
        laberintoA(m, i - 1, j, paso + 1);
        laberintoA(m, i, j + 1, paso + 1);
        laberintoA(m, i + 1, j, paso + 1);
        m[i][j] = 0;
    }
}
