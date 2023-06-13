/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package segundoparcial;

/**
 *
 * @author HP
 */
public class Segundoparcial {

    /**
     */
    public static int c = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here

        int a = 4;
        int b = 4;
        int m[][] = new int[a][b];
        //m[1][1] = -1;
        //m[2][2] = -2;
        //m[2][4] = -2;

        Laberinto.laberinto(m, 0, 0, a - 1, b - 1, 1);
        System.out.println("Soluciones: " + c);

    }

}
