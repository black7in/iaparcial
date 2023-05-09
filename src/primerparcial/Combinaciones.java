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
public class Combinaciones {
    
    public static void CombinacionesSR(LinkedList<Integer> L1, LinkedList<Integer> L2, int r, int i){
        if(L2.size() == r){
            System.out.println(L2);
            return;
        }
        
        for (int k = i; k < L1.size(); k++) {
            L2.add(L1.get(k));
            CombinacionesSR(L1, L2, r, k + 1);
            L2.removeLast();
        }
    }
    
    public static void CombinacionesCR(LinkedList<Integer> L1, LinkedList<Integer> L2, int r, int i){
        if(L2.size() == r){
            System.out.println(L2);
            return;
        }
        
        for (int k = i; k < L1.size(); k++) {
            L2.add(L1.get(k));
            CombinacionesSR(L1, L2, r, k);
            L2.removeLast();
        }
    }
}
