package com.xakyth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.xakyth.classes.Multiplication;

public class MultiplicationTest {
    
    @Test
    void simpleIntMultTest() {
        assertEquals("999890001", Multiplication.simpleIntMult("99999", "9999"));
        assertEquals("1", Multiplication.simpleIntMult("1", "1"));
        assertEquals("0", Multiplication.simpleIntMult("1", "0"));
        assertEquals("0", Multiplication.simpleIntMult("0", "1"));
        assertEquals("2", Multiplication.simpleIntMult("2", "1"));
        assertEquals("2", Multiplication.simpleIntMult("1", "2"));
        assertEquals("52", Multiplication.simpleIntMult("4", "13"));
        assertEquals("52", Multiplication.simpleIntMult("13", "4"));
        assertEquals("1219326311126352690", Multiplication.simpleIntMult("123456789", "9876543210"));
        assertEquals("8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184", Multiplication.simpleIntMult("3141592653589793238462643383279502884197169399375105820974944592", "2718281828459045235360287471352662497757247093699959574966967627"));
    } 

    @Test
    void intRecMultTest() {
        assertEquals("999890001", Multiplication.intRecMult("99999", "9999"));
        assertEquals("1", Multiplication.intRecMult("1", "1"));
        assertEquals("0", Multiplication.intRecMult("1", "0"));
        assertEquals("0", Multiplication.intRecMult("0", "1"));
        assertEquals("2", Multiplication.intRecMult("2", "1"));
        assertEquals("2", Multiplication.intRecMult("1", "2"));
        assertEquals("8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184", Multiplication.intRecMult("3141592653589793238462643383279502884197169399375105820974944592", "2718281828459045235360287471352662497757247093699959574966967627"));
        assertEquals("52", Multiplication.intRecMult("4", "13"));
        assertEquals("52", Multiplication.intRecMult("13", "4"));
        assertEquals("1219326311126352690", Multiplication.intRecMult("123456789", "9876543210"));
    }
}
