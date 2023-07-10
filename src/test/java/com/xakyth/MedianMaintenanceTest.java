package com.xakyth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.xakyth.classes.MedianMaintenance2Heaps;
import com.xakyth.classes.MedianMaintenanceBST;


public class MedianMaintenanceTest {
    @Test
    void testMaintenance() throws Exception{
        ArrayList<Integer> collection = new ArrayList<>();
        collection.add(1);
        MedianMaintenance2Heaps twoHeaps = new MedianMaintenance2Heaps(collection);
        MedianMaintenanceBST bst = new MedianMaintenanceBST(collection);
        assertEquals(bst.getMedian(), twoHeaps.getMedian());
        for (int i = 0; i < 100; i++) {
            int temp = ((-i) + 1) * 2;
            twoHeaps.add(temp);
            bst.add(temp);
            assertEquals(bst.getMedian(), twoHeaps.getMedian());
        }
    }
}