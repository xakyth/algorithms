package com.xakyth;

import com.xakyth.classes.Multiplication;

public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        String result = Multiplication.simpleIntMult("99999", "9999");
        System.out.println(result);
    }
}
