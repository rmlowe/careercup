package com.rmlowe.careercup.codes;

import java.util.ArrayList;

public class Codes {
    public static void main(String[] args) {
        System.out.println(codes("1123"));
        System.out.println(codes("11111"));
        System.out.println(codes("11111111111111111111").size());
        System.out.println();
        System.out.println(codeCount("1123"));
        System.out.println(codeCount("11111"));
        System.out.println(codeCount("11111111111111111111"));
    }

    public static int codeCount(String s) {
        int[] counts = new int[s.length()];
        counts[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            int j = Integer.parseInt(s.substring(i - 1, i + 1));
            if (j > 26) {
                counts[i] = counts[i - 1];
            } else {
                counts[i] = counts[i - 1] + (i == 1 ? 1 : counts[i - 2]);
            }
        }

        return counts[s.length() - 1];
    }

    public static ArrayList<String> codes(String s) {
        ArrayList<String> result = new ArrayList<>();
        addCodes(s, 0, "", result);
        return result;
    }

    public static void addCodes(String s, int start, String prefix, ArrayList<String> codes) {
        if (start == s.length()) {
            codes.add(prefix);
        } else {
            addCodes(s, start + 1, prefix + intToChar(Integer.parseInt(s.substring(start, start + 1))), codes);

            if (start < s.length() - 1) {
                int i = Integer.parseInt(s.substring(start, start + 2));

                if (i <= 26) {
                    addCodes(s, start + 2, prefix + intToChar(i), codes);
                }
            }
        }
    }

    private static String intToChar(int i) {
        return new String(new char[]{(char) ('a' + i - 1)});
    }
}
