package com.rmlowe.careercup.combos;

import java.util.HashMap;

public class Combinations {
    public static void main(String[] args) {
        combinations(4);
        System.out.println(combinationsCount(4));
        System.out.println(combinationsCount(5));
        System.out.println(combinationsCount(6));
    }

    private static int combinationsCount(int i) {
        HashMap<String, Integer> counts = new HashMap<>();
        return combinationsCount(i, 1, counts);
    }

    private static int combinationsCount(int i, int min, HashMap<String, Integer> counts) {
        if (i == 0) {
            return 1;
        } else if (i < min) {
            return 0;
        } else {
            String key = i + "-" + min;
            Integer value = counts.get(key);

            if (value == null) {
                int result = combinationsCount(i - min, min, counts) + combinationsCount(i, min + 1, counts);
                counts.put(key, result);
                return result;
            } else {
                return value;
            }
        }
    }

    private static void combinations(int i) {
        combinations(i, 1, "");
    }

    private static void combinations(int i, int min, String prefix) {
        if (i == 0) {
            System.out.println(prefix);
        } else if (i >= min) {
            combinations(i - min, min, prefix + min + ", ");
            combinations(i, min + 1, prefix);
        }
    }
}
