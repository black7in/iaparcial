/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primerparcial;

import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class Primerparcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();
        //Factores.factoresPosibles(L1, 25, 1);
        L1.add(1);
        L1.add(2);
        L1.add(3);
        //L1.add(4);
        //L1.add(5);
        
        Permutaciones.PermutacionesSR(L1, L2, 2);
        System.out.println(L2);
    }
    
}
