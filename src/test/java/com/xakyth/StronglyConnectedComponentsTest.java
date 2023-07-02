package com.xakyth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.xakyth.classes.StronglyConnectedComponents;

public class StronglyConnectedComponentsTest {
    @Test
    void testComputeSCC() throws Exception {
        assertEquals("4,3,3,1,0", StronglyConnectedComponents.computeSCC("scc_test0.txt"));
        assertEquals("3,3,3,0,0", StronglyConnectedComponents.computeSCC("scc_test1.txt"));
        assertEquals("3,3,2,0,0", StronglyConnectedComponents.computeSCC("scc_test2.txt"));
        assertEquals("3,3,1,1,0", StronglyConnectedComponents.computeSCC("scc_test3.txt"));
        assertEquals("7,1,0,0,0", StronglyConnectedComponents.computeSCC("scc_test4.txt"));
        assertEquals("6,3,2,1,0", StronglyConnectedComponents.computeSCC("scc_test5.txt"));
    }
}
