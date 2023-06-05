package com.xakyth;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.xakyth.classes.StrassenMatrixMult;

public class StrassenMatrixMultTest {
    @Test
    void testRecMatrixMult() {
        int[][] m1_1x1 = new int[1][1];
        int[][] m2_1x1 = new int[1][1];
        assertArrayEquals(StrassenMatrixMult.matrixMult(m1_1x1, m2_1x1), StrassenMatrixMult.recMatrixMult(m1_1x1, m2_1x1));
        m1_1x1[0][0] = 2;
        m2_1x1[0][0] = -3;
        assertArrayEquals(new int[][] { { -6 } }, StrassenMatrixMult.recMatrixMult(m1_1x1, m2_1x1));

        int[][] m1_1x2 = new int[][] { { 1, 2} };
        int[][] m2_2x1 = new int[][] { { -3 }, { 4 }};
        assertArrayEquals(StrassenMatrixMult.matrixMult(m1_1x2, m2_2x1), StrassenMatrixMult.recMatrixMult(m1_1x2, m2_2x1));
        assertArrayEquals(StrassenMatrixMult.matrixMult(m2_2x1, m1_1x2), StrassenMatrixMult.recMatrixMult(m2_2x1, m1_1x2));

        int[][] m1_2x2 = new int[][] { { 1, 2 }, { 3, 4 } };
        int[][] m2_2x2 = new int[][] { { 0, -2 }, { 5, 2 } };
        assertArrayEquals(StrassenMatrixMult.matrixMult(m1_2x2, m2_2x2), StrassenMatrixMult.recMatrixMult(m1_2x2, m2_2x2));
        assertArrayEquals(StrassenMatrixMult.matrixMult(m2_2x2, m1_2x2), StrassenMatrixMult.recMatrixMult(m2_2x2, m1_2x2));

        int[][] m1_3x2 = new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        int[][] m2_2x3 = new int[][] { { 7, 8, 9 }, {  0, 1, 2 } };
        assertArrayEquals(StrassenMatrixMult.matrixMult(m1_3x2, m2_2x3), StrassenMatrixMult.recMatrixMult(m1_3x2, m2_2x3));
        assertArrayEquals(StrassenMatrixMult.matrixMult(m2_2x3, m1_3x2), StrassenMatrixMult.recMatrixMult(m2_2x3, m1_3x2));

        int[][] m1_3x3 = new int[][] { { 1, 2, 3 }, { 1, 2, 3}, { 4, 5, 1 } };
        int[][] m2_3x3 = new int[][] { { 7, -4, 10 }, { 55, -33, 2 }, { 12, 8, -3 } };
        assertArrayEquals(StrassenMatrixMult.matrixMult(m1_3x3, m2_3x3), StrassenMatrixMult.recMatrixMult(m1_3x3, m2_3x3));
        assertArrayEquals(StrassenMatrixMult.matrixMult(m2_3x3, m1_3x3), StrassenMatrixMult.recMatrixMult(m2_3x3, m1_3x3));

        int[][] m1_4x3 = new int[][] { { 1, 84, 21 }, { 0, -9, 34 }, { 42, 55, -1 }, { 11, 93, 14 } };
        int[][] m2_3x4 = new int[][] { { 24, 1, 2, 3 }, { 84, 21, 435, 22 }, { 26, 25, 93, 74 } };
        assertArrayEquals(StrassenMatrixMult.matrixMult(m1_4x3, m2_3x4), StrassenMatrixMult.recMatrixMult(m1_4x3, m2_3x4));
        assertArrayEquals(StrassenMatrixMult.matrixMult(m2_3x4, m1_4x3), StrassenMatrixMult.recMatrixMult(m2_3x4, m1_4x3));

        int[][] m1_4x4 = new int[][] { { 1, 84, 21, -5 }, { 0, -9, 34, 7 }, { 11, 42, 55, -1 }, { 11, 12, 93, 14 } };
        int[][] m2_4x4 = new int[][] { { 24, 1, 2, 3 }, { 84, 21, 435, 22 }, { 26, 25, 93, 74 }, { 26, 25, 93, 74 } };
        assertArrayEquals(StrassenMatrixMult.matrixMult(m1_4x4, m2_4x4), StrassenMatrixMult.recMatrixMult(m1_4x4, m2_4x4));
        assertArrayEquals(StrassenMatrixMult.matrixMult(m2_4x4, m1_4x4), StrassenMatrixMult.recMatrixMult(m2_4x4, m1_4x4));
        
        int[][] m1_1x5 = new int[][] { { 1, 84, 21, 33, -5 } };
        int[][] m2_5x7 = new int[][] { { 24, 1, 2, 5, 2, 3, 3 }, { 84, 21, 0, -4, 23, 435, 22 }, { 26, 25, 93, 11, 233, -3, 74 }, { 44, 26, 25, 93, 74, 1, 2 }, { 0, 234, 75, -22, 74, 1, 2 }};
        assertArrayEquals(StrassenMatrixMult.matrixMult(m1_1x5, m2_5x7), StrassenMatrixMult.recMatrixMult(m1_1x5, m2_5x7));

    }
}
