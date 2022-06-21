package com.codegik.poc.java17;

public class LCD {
    final static private String[][] matrix = {
            {"", "   ", "___", "___",  "    ",  "___", "   ", "___", "___", "___"},
            {"", "  |", "__|",  "__|", "|__|",  "|__", "__|", " _|", "|_|", "|_|"},
            {"", "  |", "|__",  "__|", "   |",  "__|", "|_|", "  |", "|_|", "__|"}
    };


    public static String printNumber(String number) {
        String line1 = "";
        String line2 = "";
        String line3 = "";

        for (int i = 0; i < number.length(); i++) {
            final int index = Integer.valueOf("" + number.charAt(i));
            line1 += matrix[0][index] + "  ";
            line2 += matrix[1][index] + "  ";
            line3 += matrix[2][index] + "  ";
        }

        return "\n" + line1 + "\n" + line2 + "\n" + line3;
    }
}
