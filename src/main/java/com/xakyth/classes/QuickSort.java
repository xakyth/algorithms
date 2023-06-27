package com.xakyth.classes;

import java.util.Random;

public class QuickSort {
    public static int[] sort(int[] A) {
        class impl {
            public int comparisons = 0;
            
            public void swap(int[] A, int i, int j) {
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
            public void sort(int[] A, int l, int r, PivotType pivotType) {
                if (l+1 >= r) { // base case: array of size 1 is already sorted
                    this.comparisons += 1;
                    return;
                } else {
                    switch (pivotType) {
                        case FIRST:
                            break;
                        case LAST:
                            swap(A, l, r-1);
                            break;
                        case MEDIAN_OF_THREE:
                            this.comparisons += 2;
                            int medianIndex = (r + l) / 2;
                            int maxOf = A[r-1] > A[medianIndex] ? r-1 : medianIndex;
                            if (A[l] > A[maxOf]) {
                                swap(A, l, maxOf);
                            } else {
                                if (maxOf == r-1)
                                    swap(A, l, medianIndex);
                                else 
                                    swap(A, l, r-1);
                            }
                            break;
                        case RANDOM:
                            int pivotIndex = new Random().nextInt(r-l)+l;
                            swap(A, l, pivotIndex);
                            break;
                    }
                    int pivot = A[l];
                    int i = l+1;
                    this.comparisons += (r-l-1);
                    for (int j = l+1; j < r; j++) {
                        if (A[j] < pivot) {
                            swap(A, i, j);
                            i++;
                        }
                    }
                    swap(A, l, i-1);
                    sort(A, l, i-1, pivotType);
                    sort(A, i, r, pivotType);
                }
            }
        }
        impl impl = new impl();
        impl.sort(A.clone(), 0, A.length, PivotType.FIRST);
        System.out.println(String.format("first: comparisons %d", impl.comparisons));
        impl.comparisons = 0;
        impl.sort(A.clone(), 0, A.length, PivotType.LAST);
        System.out.println(String.format("last: comparisons %d", impl.comparisons));
        impl.comparisons = 0;
        impl.sort(A.clone(), 0, A.length, PivotType.RANDOM);
        System.out.println(String.format("random: comparisons %d", impl.comparisons));
        impl.comparisons = 0;
        impl.sort(A, 0, A.length, PivotType.MEDIAN_OF_THREE);
        System.out.println(String.format("median of three: comparisons %d", impl.comparisons));
        
        return A;
    }
    enum PivotType {
        FIRST,
        LAST,
        RANDOM,
        MEDIAN_OF_THREE
    }
}
