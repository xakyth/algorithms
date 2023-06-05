package com.xakyth.classes;

public class StrassenMatrixMult {
    
    //TODO: Strassen's matrix mult

    public static int[][] recMatrixMult(int[][] X, int[][] Y) {
        
        class impl {
            int[][] recMatrixMult(int[][] A, int[][] B, int ax1, int ax2, int ay1, int ay2, int bx1, int bx2, int by1, int by2) {
                if (ay1 == ay2 && bx1 == bx2) {
                    int[][] C = new int[1][1];
                    for (int i = ax1, j = by1; i <= ax2; i++, j++) {
                        C[0][0] += A[ay1][i] * B[j][bx1];
                    }
                    return C;
                } else if (ax1 == ax2 && by1 == by2) {
                    int[][] C = new int[ay2 - ay1 + 1][bx2 - bx1 + 1];
                    for (int i = ay1; i <= ay2; i++) {
                        for (int j = bx1; j <= bx2; j++) {
                            C[i - ay1][j - bx1] = A[i][ax1] * B[by1][j];
                        }
                    }
                    return C;
                } else {
                    int[][] C = new int[ay2 - ay1 + 1][bx2 - bx1 + 1];

                    //ae + bg
                    int[][] ae = recMatrixMult(A, B, ax1, (ax2 + ax1) / 2, ay1, (ay2+ay1) / 2, bx1, (bx1+bx2)/2, by1, (by1+by2)/2);
                    int[][] bg = recMatrixMult(A, B, (ax2 + ax1) / 2 + 1, ax2, ay1, (ay2+ay1) / 2, bx1, (bx1+bx2)/2, (by1+by2)/2+1, by2);
                    
                    //af + bh
                    int[][] af = recMatrixMult(A, B, ax1, (ax2 + ax1) / 2, ay1, (ay2+ay1) / 2, (bx1+bx2)/2+1, bx2, by1, (by1+by2)/2);
                    int[][] bh = recMatrixMult(A, B, (ax2 + ax1) / 2+1, ax2, ay1, (ay2+ay1) / 2, (bx1+bx2)/2+1, bx2, (by1+by2)/2+1, by2);

                    //ce + dg
                    int[][] ce = recMatrixMult(A, B, ax1, (ax2 + ax1) / 2, (ay2+ay1) / 2+1, ay2, bx1, (bx1+bx2)/2, by1, (by1+by2)/2);
                    int[][] dg = recMatrixMult(A, B, (ax2 + ax1) / 2 + 1, ax2, (ay2+ay1) / 2+1, ay2, bx1, (bx1+bx2)/2, (by1+by2)/2+1, by2);

                    //cf + dh
                    int[][] cf = recMatrixMult(A, B, ax1, (ax2 + ax1) / 2, (ay2+ay1) / 2 + 1, ay2, (bx1+bx2)/2+1, bx2, by1, (by1+by2)/2);
                    int[][] dh = recMatrixMult(A, B, (ax2 + ax1) / 2+1, ax2, (ay2+ay1) / 2+1, ay2, (bx1+bx2)/2+1, bx2, (by1+by2)/2+1, by2);

                    for (int i = 0; i < C.length; i++) {
                        for (int j = 0; j < C[0].length; j++) {
                            if (i < ae.length && j < ae[0].length) {
                                C[i][j] = ae[i][j] + bg[i][j];
                            } else if (i < ae.length && j >= ae[0].length) {
                                C[i][j] = af[i][j-ae[0].length] + bh[i][j-ae[0].length];
                            } else if (i >= ae.length && j < ae[0].length) {
                                C[i][j] = ce[i - ae.length][j] + dg[i - ae.length][j];
                            } else {
                                C[i][j] = cf[i - ae.length][j - ae[0].length] + dh[i - ae.length][j - ae[0].length];
                            }
                        }
                    }

                    return C;
                }  

            }
        }

        return new impl().recMatrixMult(X, Y, 0, X[0].length-1, 0, X.length-1, 0, Y[0].length-1, 0, Y.length-1);
    }

    public static int[][] matrixMult(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

}
