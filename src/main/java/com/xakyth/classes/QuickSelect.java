package com.xakyth.classes;

import java.util.Random;

public class QuickSelect {
    public static int quickSelect(int[] A, int k) {
        return quickSelectImpl(A, 0, A.length-1, k);
    }

    private static int quickSelectImpl(int[] A, int l, int r, int k) {
        if (l >= r) {
            return A[l];
        }
        Random random = new Random();
        int pivotIndex = random.nextInt(r-l+1) + l;
        swap(A, l, pivotIndex);
        pivotIndex = l;
        for (int i = l + 1; i <= r; i++) {
            if (A[i] < A[l]) {
                pivotIndex++;
                swap(A, pivotIndex, i);
            } 
        }
        swap(A, pivotIndex, l);
        if (pivotIndex == k) {
            return A[k];
        } else if (pivotIndex < k) {
            return quickSelectImpl(A, pivotIndex+1, r, k);
        } else {
            return quickSelectImpl(A, l, pivotIndex-1, k);
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
