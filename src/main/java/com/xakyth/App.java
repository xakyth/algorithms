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
        String result = Multiplication.intRecMult("4", "13");
        System.out.println(result);
    }
}
 