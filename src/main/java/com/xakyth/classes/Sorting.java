package com.xakyth.classes;

public class Sorting {
    
    public static int[] mergeSort(int[] A) {
        
        class impl { 
            int[] mergeSort(int[] A, int l, int r) {
                if (l >= r) {
                    return A;
                }
                int mid = (l + r) / 2;
                mergeSort(A, l, mid);
                mergeSort(A, mid + 1, r);
                return this.merge(A, l, mid, r);
            }
            
            int[] merge(int[] A, int l, int mid, int r) {
                int[] merged = new int[r - l + 1];
                int i = l, j = mid + 1;
                for (int k = 0; k < merged.length; k++) {
                    if (j > r || (i <= mid && A[i] <= A[j])) {
                        merged[k] = A[i];
                        i++;
                    } else {
                        merged[k] = A[j];
                        j++;
                    }
                }
                System.arraycopy(merged, 0, A, l, merged.length);
                return A;
            }
        }
        
        return new impl().mergeSort(A, 0, A.length-1);
        
    }
}
