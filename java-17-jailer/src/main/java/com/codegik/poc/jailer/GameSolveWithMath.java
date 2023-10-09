package com.codegik.poc.jailer;

public class GameSolveWithMath {

    public int awfulCandyGoesTo(int prisoners, int candyPieces, int startAt) {
        var result = 0;

        if (prisoners >= candyPieces) {
            result = candyPieces + startAt - 1;
        } else {
            result = candyPieces % prisoners + startAt - 1;
            result = result == 0 ? prisoners : result;
        }

        return result > prisoners ? result - prisoners : result;
    }

}
