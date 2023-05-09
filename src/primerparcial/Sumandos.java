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
public class Sumandos {

    public Sumandos() {
    }
    
    // < INICIO CODIGO BASE >
    private int sumar(LinkedList<Integer> L1){
        int suma = 0;
        for (int i = 0; i < L1.size(); i++) {
            suma += L1.get(i);
        }
        
        return suma;
    }
    
    public void sumandosPosibles(LinkedList<Integer> L1, int N, int i){
        int suma = sumar(L1);
        if(suma > N)
            return;
        if(suma == N){
            System.out.println(L1);
            return;
        }
        
        for (int j = i; j <= N; j++) {
            L1.add(j);
            sumandosPosibles(L1, N, j);
            L1.removeLast();
        }
    }
    
    // < FIN CODIGO BASE >
    
    // < INICIO VARIANTES SUMANDO >
}
