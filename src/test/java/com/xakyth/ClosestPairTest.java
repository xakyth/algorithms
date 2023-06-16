package com.xakyth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.xakyth.classes.ClosestPair;
import com.xakyth.util.Pair;
import com.xakyth.util.Point;

public class ClosestPairTest {
    
    @Test
    void findClosestPair() {
        ArrayList<Point> P = new ArrayList<>();
        P.add(new Point(1, 1));
        P.add(new Point(2, 2));
        Pair<Point, Point> res = ClosestPair.findClosestPair(P.toArray(new Point[P.size()]));
        assertEquals(1, res.getKey().x, 0.001);
        assertEquals(1, res.getKey().y, 0.001);
        assertEquals(2, res.getValue().x, 0.001);
        assertEquals(2, res.getValue().y, 0.001);
        
        P.add(new Point(4, 4));
        res = ClosestPair.findClosestPair(P.toArray(new Point[P.size()]));
        assertEquals(1, res.getKey().x, 0.001);
        assertEquals(1, res.getKey().y, 0.001);
        assertEquals(2, res.getValue().x, 0.001);
        assertEquals(2, res.getValue().y, 0.001);

        P.add(new Point(4.9, 4.9));
        res = ClosestPair.findClosestPair(P.toArray(new Point[P.size()]));
        assertEquals(4, res.getKey().x, 0.001);
        assertEquals(4, res.getKey().y, 0.001);
        assertEquals(4.9, res.getValue().x, 0.001);
        assertEquals(4.9, res.getValue().y, 0.001);

        P.add(new Point(-10, -3));
        P.add(new Point(9, -3.05));
        P.add(new Point(7, 3));
        P.add(new Point(7.05, -9));
        assertEquals(4, res.getKey().x, 0.001);
        assertEquals(4, res.getKey().y, 0.001);
        assertEquals(4.9, res.getValue().x, 0.001);
        assertEquals(4.9, res.getValue().y, 0.001);
    }   
}
