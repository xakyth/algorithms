package com.xakyth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.xakyth.classes.QuickSelect;

public class QuickSelectTest {
    
    @Test
    void testQuickselect() {
        assertEquals(-2, QuickSelect.quickSelect(new int[] { 1, 2, 3, 10, 44, -2, 5 }, 0));
        assertEquals(1, QuickSelect.quickSelect(new int[] { 1, 2, 3, 10, 44, 5, -2 }, 1));
        assertEquals(2, QuickSelect.quickSelect(new int[] { 1, 2, 3, 10, 44, 5, -2 }, 2));
        assertEquals(3, QuickSelect.quickSelect(new int[] { 1, 2, 3, 10, 44, 5, -2 }, 3));
        assertEquals(5, QuickSelect.quickSelect(new int[] { 1, 2, 3, 10, 44, 5, -2 }, 4));
        assertEquals(10, QuickSelect.quickSelect(new int[] { 1, 2, 3, 10, 44, 5, -2 }, 5));
        assertEquals(44, QuickSelect.quickSelect(new int[] { 1, 2, 3, 10, 44, 5, -2 }, 6));
        
        Random random = new Random();
        int[] A = new int[1000];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 1000; j++) {
                A[j] = random.nextInt(1000);
            }
            int k = random.nextInt(1000);
            int[] B = A.clone();
            Arrays.sort(B);
            assertEquals(B[k], QuickSelect.quickSelect(A, k));
        }
    }
}
