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
public class Permutaciones {

    public static void PermutacionesSR(LinkedList<Integer> L1, LinkedList<Integer> L2, int r) {
        if (L2.size() == r) {
            System.out.println(L2);
            return;
        }

        for (int k = 0; k < L1.size(); k++) {
            if (!L2.contains(L1.get(k))) {
                L2.add(L1.get(k));
                PermutacionesSR(L1, L2, r);
                L2.removeLast();
            }
        }
    }

    public static void PermutacionesCR(LinkedList<Integer> L1, LinkedList<Integer> L2, int r) {
        if (L2.size() == r) {
            System.out.println(L2);
            return;
        }

        for (int k = 0; k < L1.size(); k++) {
            L2.add(L1.get(k));
            PermutacionesCR(L1, L2, r);
            L2.removeLast();
        }
    }

}
