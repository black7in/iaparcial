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
public class Factores {

    public Factores() {
    }
    
    // < INICIO CODIGO BASE >
    private static int sumar(LinkedList<Integer> L1){
        int suma = 0;
        for (int i = 0; i < L1.size(); i++) {
            suma += L1.get(i);
        }
        
        return suma;
    }
    
    private static int factor(LinkedList<Integer> L1) {
        int num = 1;
        for (int i = 0; i < L1.size(); i++) {
            num *= L1.get(i);
        }
        
        return num;
    }
    
    public static void factoresPosibles(LinkedList<Integer> L1, int N, int i){
        int suma = sumar(L1);
        int fac = factor(L1);
        
        if(suma > N + 1)
            return;
        
        if(fac == N  /*&& L1.size() == 2*/){
            System.out.println(L1);
            return;
        }
        
        for (int j = i; j <= N; j++) {
            L1.add(j);
            factoresPosibles(L1, N, j);
            L1.removeLast();
        } 
    }    
}
