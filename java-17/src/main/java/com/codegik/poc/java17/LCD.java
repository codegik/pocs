package com.codegik.poc.java17;

public class LCD {
    final private String[][] matrix = {
            {"   ", "___", "___",  "    ",  "___", "   ", "___", "___", "___"},
            {"  |", "__|",  "__|", "|__|",  "|__", "__|", " _|", "|_|", "|_|"},
            {"  |", "|__",  "__|", "   |",  "__|", "|_|", "  |", "|_|", "__|"}
    };

    public String printNumber(String number) {
        String result = "\n";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < number.length(); j++) {
                final int index = Integer.valueOf("" + number.charAt(j)) - 1;
                if (index >= 0 && index < 9) {
                    result += matrix[i][index] + "  ";
                }
            }
            result += "\n";
        }

        return result;
    }
}
