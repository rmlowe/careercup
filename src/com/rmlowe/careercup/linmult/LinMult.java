package com.rmlowe.careercup.linmult;

import java.util.Arrays;

public class LinMult {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(products(new int[]{2, 3, 1, 4})));
        System.out.println(Arrays.toString(products(new int[]{3})));
        System.out.println(Arrays.toString(products(new int[0])));
    }

    private static int[] products(int[] ints) {
        int[] leftProducts = new int[ints.length];
        int[] rightProducts = new int[ints.length];

        leftProducts[0] = 1;
        for (int i = 1; i < ints.length; i++) {
            leftProducts[i] = leftProducts[i - 1] * ints[i - 1];
        }
        //System.out.println(Arrays.toString(leftProducts));

        rightProducts[ints.length - 1] = 1;
        for (int i = ints.length - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * ints[i + 1];
        }

        int[] result = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }
}
