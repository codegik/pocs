package com.codegik.poc.diamond;

import java.util.Arrays;
import java.util.List;

public class Diamond {
    private final List<String> alpha = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                                                     "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    public String write(String letter) {
        var letterPosition = alpha.indexOf(letter);
        var nextPositionLeft = letterPosition + 1;
        var nextPositionRight = letterPosition - 1;
        var maxColumns = (letterPosition * 2) + 1;
        var maxLines = (letterPosition * 2) + 1;
        var letterReached = false;
        var letterIndex = 0;
        var result = "";

        for (var line = 0; line < maxLines; line++) {
            if (letterReached) {
                letterIndex--;
                nextPositionLeft++;
                nextPositionRight--;
            } else {
                letterIndex = line;
                nextPositionLeft--;
                nextPositionRight++;
            }

            for (var column = 0; column < maxColumns; column++) {
                if ((line == 0 || line == maxLines - 1) && column == letterPosition) {
                    result += alpha.get(letterIndex) + "\n";
                    break;
                } else if (line > 0) {
                    if (column == nextPositionLeft) {
                        result += alpha.get(letterIndex);
                        if (column == 0) {
                            letterReached = true;
                        }
                    } else if (column == nextPositionRight) {
                        result += alpha.get(letterIndex) + "\n";
                        break;
                    } else {
                        result += " ";
                    }
                } else {
                    result += " ";
                }
            }
        }

        return result;
    }
}
