package com.rmlowe.careercup.kpal;

public class KPalindrome {
    public static void main(String[] args) {
        testIsKPalindrome("abxa", 1, true);
        testIsKPalindrome("abdxa", 1, false);
        testIsKPalindrome("abdxa", 2, true);
        testIsKPalindrome("hannah", 0, true);
        testIsKPalindrome("tenet", 0, true);
        testIsKPalindrome("madam i'm adam", 3, true);
        testIsKPalindrome("madam i'm adam", 2, false);
        testIsKPalindrome("a man a plan a canal panama", 6, true);
        testIsKPalindrome("a man a plan a canal panama", 5, false);
    }

    private static void testIsKPalindrome(String s, int k, boolean expected) {
        System.out.println("isKPalindrome(" + s + ", " + k + "): " + isKPalindrome(s, k) + " (expected: " + expected + ")");
    }

    public static boolean isKPalindrome(String s, int k) {
        return isKPalindrome(s, k, 0, s.length());
    }

    private static boolean isKPalindrome(String s, int k, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end - 1)) {
                start++;
                end--;
            } else if (k <= 0) {
                return false;
            } else {
                return isKPalindrome(s, k - 1, start + 1, end) || isKPalindrome(s, k - 1, start, end - 1);
            }
        }

        return true;
    }
}
