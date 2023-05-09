/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class Mochila {

    public Mochila() {
    }
    
    // < INICIO CODIGO BASE >
    private static int sumar(LinkedList<Integer> L1){
        int suma = 0;
        for (int i = 0; i < L1.size(); i++) {
            suma += L1.get(i);
        }
        
        return suma;
    }
    
    //  Encontrar todas las combinaciones de pesos de objetos que se pueden transportar en la mochila.
    public static void TodasCombinaciones(LinkedList<Integer> L1, LinkedList<Integer> L2, int MAX, int i) {
        int sum = sumar(L2);
        if (sum > MAX) {
            return;
        }
        
        // Restricciones -> sonDiferentes
        System.out.println(L2);

        for (int k = i; k < L1.size(); k++) {
            L2.add(L1.get(k));
            TodasCombinaciones(L1, L2, MAX, k + 1);
            L2.removeLast();
        }
    }
    
    // < FIN CODIGO BASE >
}
