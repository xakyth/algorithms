package com.xakyth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.xakyth.classes.InversionsCount;

public class InversionsCountTest {
    
    @Test
    void testInversionsCount() {
        assertEquals(0, InversionsCount.inversionsCount(new int[] { }));
        assertEquals(0, InversionsCount.inversionsCount(new int[] { 0 }));
        assertEquals(0, InversionsCount.inversionsCount(new int[] { -1 }));
        assertEquals(0, InversionsCount.inversionsCount(new int[] { 1 }));

        assertEquals(0, InversionsCount.inversionsCount(new int[] { 0, 1 }));
        assertEquals(0, InversionsCount.inversionsCount(new int[] { 1, 1 }));
        assertEquals(1, InversionsCount.inversionsCount(new int[] { 2, 1 }));
            
        assertEquals(1, InversionsCount.inversionsCount(new int[] { -1, 2, 1 }));
        assertEquals(3, InversionsCount.inversionsCount(new int[] { 4, 2, 1 }));
        assertEquals(2, InversionsCount.inversionsCount(new int[] { 2, 3, 1 }));
        assertEquals(0, InversionsCount.inversionsCount(new int[] { -1, 0, 1 }));

        assertEquals(0, InversionsCount.inversionsCount(new int[] { -1, 0, 1, 7, 10 }));
        assertEquals(4, InversionsCount.inversionsCount(new int[] { 11, 0, 1, 7, 10 }));
        assertEquals(28, InversionsCount.inversionsCount(new int[] { 54044, 14108, 79294, 29649, 25260, 60660, 2995, 53777, 49689, 9083}));

    }
}
