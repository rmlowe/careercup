package com.rmlowe.careercup.celebs;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class Celebreties {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(celebrities(5, (Integer a, Integer b) -> b == 2)));
        System.out.println(Arrays.toString(celebrities(5, (Integer a, Integer b) -> a < b)));
        System.out.println(Arrays.toString(celebrities(5, (Integer a, Integer b) -> Math.abs(a - b) < 2)));
    }

    private static int[] celebrities(int n, BiPredicate<Integer, Integer> knows) {
        int candidate = 0;

        for (int i = 1; i < n; i++) {
            if (knows.test(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows.test(candidate, i) || !knows.test(i, candidate))) {
                return new int[0];
            }
        }

        return new int[]{candidate};
    }
}
