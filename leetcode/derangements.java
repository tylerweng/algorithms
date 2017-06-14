package com.utils;

public class Derangement {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(subfactorial(i));
        }


    }

    public static int subfactorial(int n) {

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 0;
        }

        return (n - 1) * (subfactorial(n - 1) + subfactorial(n - 2));
    }
}
