package com.xakyth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.xakyth.classes.DijkstraShortestPath;

public class DijkstraShortestPathTest {
    @Test
    void testSearch() throws Exception{
        assertEquals("8710,10229,3412,8191,3720,12280,11964,9855,9627,6422", DijkstraShortestPath.search(DijkstraShortestPath.initGraphFromFile("dijkstra_test1.txt"), 1));
        assertEquals("588,405,675,521,909,328,418,957,830,839", DijkstraShortestPath.search(DijkstraShortestPath.initGraphFromFile("dijkstra_test2.txt"), 1));
    }
}
