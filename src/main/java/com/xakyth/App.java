package com.xakyth;

import java.util.Random;

import com.xakyth.classes.Multiplication;
import com.xakyth.classes.QuickSort;

public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */  
    public static void main(String[] args) {
        String result = Multiplication.intRecMult("4", "13");
        System.out.println(result);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int[] A = new int[10000];
            for (int j = 0; j < 10000; j++) {
                A[j] = random.nextInt(10000);
            }
            QuickSort.sort(A);
            System.out.println();
        }
        

    }
}
 