package com.xakyth.classes;

public class StrassenMatrixMult {
    
    //Strassen's matrix mult (assume matrix 2^n x 2^n size)
    public static int[][] strassenMatrixMult(int[][] X, int[][] Y) {
        class impl {
            int[][] strassenMatrixMult(int[][] A, int[][] B) {
                if (A.length == 1) {
                    int[][] C = new int[][] { { A[0][0] * B[0][0]} };
                    return C;
                } else {
                    int n = A.length;
                    int[][] C = new int[n][n];
                    int[][] a = new int[n/2][n/2];
                    int[][] b = new int[n/2][n/2];
                    int[][] c = new int[n/2][n/2];
                    int[][] d = new int[n/2][n/2];
                    int[][] e = new int[n/2][n/2];
                    int[][] f = new int[n/2][n/2];
                    int[][] g = new int[n/2][n/2];
                    int[][] h = new int[n/2][n/2];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i < n/2 && j < n/2) {
                                a[i][j] = A[i][j];
                                e[i][j] = B[i][j];
                            } else if (i < n/2 && j >= n/2) {
                                b[i][j-n/2] = A[i][j];
                                f[i][j-n/2] = B[i][j];
                            } else if (i >= n/2 && j < n/2) {
                                c[i-n/2][j] = A[i][j];
                                g[i-n/2][j] = B[i][j];
                            } else {
                                d[i-n/2][j-n/2] = A[i][j];
                                h[i-n/2][j-n/2] = B[i][j];
                            }
                        }
                    }

                    //p1 = a(f-h)
                    int[][] p1 = strassenMatrixMult(a, subtract(f, h));
                    //p2 = (a+b)h
                    int[][] p2 = strassenMatrixMult(add(a, b), h);
                    //p3 = (c+d)e
                    int[][] p3 = strassenMatrixMult(add(c, d), e);
                    //p4 = d(g-e)
                    int[][] p4 = strassenMatrixMult(d, subtract(g, e));
                    //p5 = (a+d)(e+h)
                    int[][] p5 = strassenMatrixMult(add(a, d), add(e, h));
                    //p6 = (b-d)(g+h)
                    int[][] p6 = strassenMatrixMult(subtract(b, d), add(g, h));
                    //p7 = (a-c)(e+f)
                    int[][] p7 = strassenMatrixMult(subtract(a, c), add(e, f));

                    int[][] q1 = add(subtract(add(p5, p4), p2), p6);
                    int[][] q2 = add(p1, p2);
                    int[][] q3 = add(p3, p4);
                    int[][] q4 = subtract(subtract(add(p1, p5), p3), p7);
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i < n/2 && j < n/2) {
                                C[i][j] = q1[i][j];
                            } else if (i < n/2 && j >= n/2) {
                                C[i][j] = q2[i][j-n/2];
                            } else if (i >= n/2 && j < n/2) {
                                C[i][j] = q3[i-n/2][j];
                            } else {
                                C[i][j] = q4[i-n/2][j-n/2];
                            }
                        }
                    }

                    return C;
                }
            } 
            int[][] add(int[][] A, int[][] B) {
                int[][] C = new int[A.length][A[0].length];
                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < A[0].length; j++) {
                            C[i][j] = A[i][j] + B[i][j];
                    }
                }
                return C;
            }
            int[][] subtract(int[][] A, int[][] B) {
                int[][] C = new int[A.length][A[0].length];
                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < A[0].length; j++) {
                            C[i][j] = A[i][j] - B[i][j];
                    }
                }
                return C;
            }

        }

        return new impl().strassenMatrixMult(X, Y);
    }
    
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
