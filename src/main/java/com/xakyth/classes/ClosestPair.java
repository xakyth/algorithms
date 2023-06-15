package com.xakyth.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import com.xakyth.util.Pair;
import com.xakyth.util.Point;

public class ClosestPair {
    public static Pair<Point, Point> findClosestPair(Point[] P) {

        class implementation {
            Pair<Point, Point> search(Point[] P_x, Point[] P_y) {
                int n = P_x.length;
                //base case n == 2 || n == 3
                if (n <= 3) {
                    Pair<Point, Point> result = new Pair<Point,Point>(P_x[0], P_x[1]);
                    if (n == 3) {
                        double bestD = computeDistance(P_x[0], P_x[1]);
                        double d = computeDistance(P_x[0], P_x[2]);
                        if (d < bestD) {
                            bestD = d;
                            result = new Pair<Point, Point>(P_x[0], P_x[2]);
                        }
                        d = computeDistance(P_x[1], P_x[2]);
                        if (d < bestD) {
                            result = new Pair<Point, Point>(P_x[1], P_x[2]);
                        }
                    }
                    return result;
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
                    Pair<Point, Point> leftPair = search(L_x, L_y);
                    Pair<Point, Point> rightPair = search(R_x, R_y);
                    double d1 = computeDistance(leftPair.getKey(), leftPair.getValue());
                    double d2 = computeDistance(rightPair.getKey(), rightPair.getValue());
                    Pair<Point, Point> splitPair = null;
                    if (d1 <= d2) {
                        splitPair = searchSplitPair(P_x, P_y, d1, leftPair);
                    } else {
                        splitPair = searchSplitPair(P_x, P_y, d2, rightPair);
                    }
                    return splitPair;
                }
            }
            public Pair<Point, Point> searchSplitPair(Point[] P_x, Point[] P_y, double d, Pair<Point, Point> bestPair) {
                double median_x = P_x[(P_x.length % 2 == 0) ? P_x.length / 2 - 1 : P_x.length].x;
                ArrayList<Point> S_y = new ArrayList<>();
                for (int i = 0; i < P_y.length; i++) {
                    if (Math.abs(P_y[i].x - median_x) < d) {
                        S_y.add(P_y[i]);
                    }
                }
                for (int i = 0; i < S_y.size() - 1; i++) {
                    for (int j = i + 1; j < Math.min(i + 8, S_y.size()); j++) {
                        double tempD = computeDistance(S_y.get(i), S_y.get(j));
                        if (tempD < d) {
                            d = tempD;
                            bestPair = new Pair<Point,Point>(S_y.get(i), S_y.get(j));
                        }
                    }
                }
                return bestPair;
            }
            public double computeDistance(Point p1, Point p2) {
                return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
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
        System.arraycopy(P, 0, P_y, 0, P_x.length);
        Arrays.sort(P_y, 0, P_y.length, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return Double.compare(p1.y, p2.y);
            }
        });
        return new implementation().search(P_x, P_y);

    }
}
