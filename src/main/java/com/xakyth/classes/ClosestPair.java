package com.xakyth.classes;

import java.util.Arrays;
import java.util.Comparator;

import com.xakyth.util.Pair;
import com.xakyth.util.Point;

public class ClosestPair {
    public Pair<Point, Point> findClosestPair(Point[] P) {

        class implementation {
            Pair<Point, Point> search(Point[] P_x, Point[] P_y) {
                int n = P_x.length;

                //base case
                if (n <= 3) {
                    //TODO:
                    return null;
                } else {
                    Point[] L_x = new Point[n / 2];
                    Point[] L_y = new Point[n / 2];
                    Point[] R_x = new Point[n - n / 2];
                    Point[] R_y = new Point[n - n / 2];
                    System.arraycopy(P_x, 0, L_x, 0, n/2);
                    System.arraycopy(P_x, n/2, R_x, 0, n-n/2);
                    Double mid_x = L_x[n / 2 - 1].x;
                    for (int i = 0, l = 0, r = 0; i < n; i++) {
                        if (P_y[i].x <= mid_x) {
                            L_y[l] = P_y[i];
                            l++;
                        } else {
                            R_y[r] = P_y[i];
                            r++;
                        }
                    }
                    //TODO: find best of 3
                    Pair<Point, Point> leftPair = search(L_x, L_y);
                    Pair<Point, Point> rightPair = search(R_x, R_y);
                    Pair<Point, Point> splitPair = searchSplitPair(P_x, P_y, 0, rightPair);
                    return null;
                }
            }
            //TODO: implement serachSplitPair
            public Pair<Point, Point> searchSplitPair(Point[] P_x, Point[] P_y, double d, Pair<Point, Point> bestPair) {

                return bestPair;
            }
        }
        //cloning P_x and P_y from P. P_x sorted by X, P_y sorted by Y
        Point[] P_x = P;
        Arrays.sort(P_x, 0, P_x.length, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return Double.compare(p1.x, p2.x);
            }
        });
        Point[] P_y = new Point[P_x.length];
        System.arraycopy(P, 0, P_y, 0, P_x.length];
        Arrays.sort(P_y, 0, P_y.length, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return Double.compare(p1.y, p2.y);
            }
        });

    }
}
