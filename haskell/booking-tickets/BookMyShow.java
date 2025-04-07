package com.lendingclub.array;

import java.util.Arrays;

class BookMyShow {
    private final int m;
    private int startRow;
    private final int[] left;

    public BookMyShow(int n, int m) {
        this.m = m;
        left = new int[n];
        Arrays.fill(left, m);
    }

    public int[] gather(int k, int maxRow) {
        for (int i = startRow; i <= maxRow; i++) {
            if (left[i] >= k) {
                left[i] -= k;
                return new int[] {i, m - left[i] - k};
            }
        }
        return new int[] {};
    }

    public boolean scatter(int k, int maxRow) {
        int i = startRow;
        for ( ; i <= maxRow; i++) {
            if (k - left[i] < 0) {
                break;
            }
            k -= left[i];
        }
        if (i >= maxRow + 1) {
            if (k == 0) {
                startRow = i;
                return true;
            }
            return false;
        }
        startRow = i;
        left[i] -= k;
        return true;
    }

    public static void main(String[] args) {
        BookMyShow bookShow = new BookMyShow(2, 5);
        System.out.println("gather: " + Arrays.toString(bookShow.gather(4, 0)));
        System.out.println("gather: " + Arrays.toString(bookShow.gather(2, 0)));
        System.out.println("scatter: " + bookShow.scatter(5, 1));
        System.out.println("scatter: " + bookShow.scatter(5, 1));
    }
}

