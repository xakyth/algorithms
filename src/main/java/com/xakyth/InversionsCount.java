package com.xakyth;

public class InversionsCount {
    
    public static int inversionsCount(int[] A) {
        class impl {
            int InvSumAndMerge(int[] A, int l, int r) {
                if (l >= r) {
                    return 0;
                }
                int mid = (l + r) / 2;
                return InvSumAndMerge(A, l, mid) + InvSumAndMerge(A, mid+1, r) + merge(A, l, mid, r);
            }

            int merge(int[] A, int l, int mid, int r) {
                int[] merged = new int[r - l + 1];
                int i = l, j = mid + 1, invCount = 0;
                for (int k = 0; k < merged.length; k++) {
                    if (j > r || (i <= mid && A[i] <= A[j])) {
                        merged[k] = A[i];
                        i++;
                    } else {
                        merged[k] = A[j];
                        j++;
                        invCount += (mid - i + 1);
                    }
                }
                System.arraycopy(merged, 0, A, l, merged.length);
                return invCount;
            }
        }
        return new impl().InvSumAndMerge(A, 0, A.length-1);
    }
}
