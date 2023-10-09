package com.codegik.poc.jailer;

public class GameSolveWithLoop {

    public int awfulCandyGoesTo(int prisoners, int candyPieces, int startAt) {
        var candies = candyPieces + 0;

        for (int i = startAt; i <= prisoners;) {
            candies--;
            if (candies == 0) {
                return i;
            }
            i = i == prisoners ? 1 : i + 1;
        }

        return -1;
    }

}
