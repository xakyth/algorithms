package com.xakyth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.xakyth.classes.PrimMST;
import com.xakyth.classes.StronglyConnectedComponents;

public class PrimMSTTest {
    @Test
    void searchMST() throws Exception {
        assertEquals(14, PrimMST.f("MSTTest0.txt"));
        assertEquals(-97121, PrimMST.f("MSTTest1.txt"));
    }
}
