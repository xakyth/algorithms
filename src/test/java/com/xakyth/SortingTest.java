package com.xakyth;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.xakyth.classes.Sorting;

public class SortingTest {
    
    @Test
    void mergeSortTest() {
        assertArrayEquals(new int[] { 1, 2, 3, 4 }, Sorting.mergeSort(new int[] { 4, 3, 2, 1}));
        assertArrayEquals(new int[0], Sorting.mergeSort(new int[0]));
        assertArrayEquals(new int[] { 1 }, Sorting.mergeSort(new int[] { 1 }));
        assertArrayEquals(new int[] { 1, 2 }, Sorting.mergeSort(new int[] { 1, 2 }));
        assertArrayEquals(new int[] { 1, 2 }, Sorting.mergeSort(new int[] { 2, 1 }));
        assertArrayEquals(new int[] { 1, 2, 3 }, Sorting.mergeSort(new int[] { 3, 2, 1}));
        assertArrayEquals(new int[] { 1, 2, 3, 7, 11 }, Sorting.mergeSort(new int[] { 3, 7, 2, 1, 11 }));
        assertArrayEquals(new int[] { -5, 1, 2, 3, 7, 11 }, Sorting.mergeSort(new int[] { 3, 7, 2, -5, 1, 11 }));
        assertArrayEquals(new int[] { -5, 1, 2, 3, 5, 7, 11 }, Sorting.mergeSort(new int[] { 3, 7, 2, -5, 1, 11, 5 }));
        assertArrayEquals(new int[] { -5, 1, 2, 3, 5, 7, 11, 99 }, Sorting.mergeSort(new int[] { 99, 3, 7, 2, -5, 1, 11, 5 }));
        assertArrayEquals(new int[] { -5, 0, 1, 2, 3, 5, 7, 11, 99 }, Sorting.mergeSort(new int[] { 99, 3, 7, 0, 2, -5, 1, 11, 5 }));
    }
}
