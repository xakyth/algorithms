package com.xakyth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.xakyth.classes.KruskalMST;

public class KruskalMSTTest {
    @Test
    void searchMST() throws Exception {
        assertEquals(14, KruskalMST.search(KruskalMST.initGraph(("MSTTest0.txt"))));
        assertEquals(-97121, KruskalMST.search(KruskalMST.initGraph(("MSTTest1.txt"))));
    }
}
