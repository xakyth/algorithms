package com;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.xakyth.classes.QuickSort;


public class QuickSortTest {

    @Test
    void QuickSortTest() {
        assertArrayEquals(new int[] { 1, 2, 3, 4 }, QuickSort.sort(new int[] { 4, 3, 2, 1}));
        assertArrayEquals(new int[0], QuickSort.sort(new int[0]));
        assertArrayEquals(new int[] { 1 }, QuickSort.sort(new int[] { 1 }));
        assertArrayEquals(new int[] { 1, 2 }, QuickSort.sort(new int[] { 1, 2 }));
        assertArrayEquals(new int[] { 1, 2 }, QuickSort.sort(new int[] { 2, 1 }));
        assertArrayEquals(new int[] { 1, 2, 3 }, QuickSort.sort(new int[] { 3, 2, 1}));
        assertArrayEquals(new int[] { 1, 2, 3, 7, 11 }, QuickSort.sort(new int[] { 3, 7, 2, 1, 11 }));
        assertArrayEquals(new int[] { -5, 1, 2, 3, 7, 11 }, QuickSort.sort(new int[] { 3, 7, 2, -5, 1, 11 }));
        assertArrayEquals(new int[] { -5, 1, 2, 3, 5, 7, 11 }, QuickSort.sort(new int[] { 3, 7, 2, -5, 1, 11, 5 }));
        assertArrayEquals(new int[] { -5, 1, 2, 3, 5, 7, 11, 99 }, QuickSort.sort(new int[] { 99, 3, 7, 2, -5, 1, 11, 5 }));
        assertArrayEquals(new int[] { -5, 0, 1, 2, 3, 5, 7, 11, 99 }, QuickSort.sort(new int[] { 99, 3, 7, 0, 2, -5, 1, 11, 5 }));
        int[] A = new int[1000];
        Random random = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = random.nextInt(1000);
        }
        int[] expected = A.clone();
        Arrays.sort(expected);
        assertArrayEquals(expected, QuickSort.sort(A));
    }
}
