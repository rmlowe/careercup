package com.rmlowe.careercup.excel;

public class ExcelNumbering {
    public static void main(String[] args) {
        System.out.println(numberToCell(1));
        System.out.println(numberToCell(26));
        System.out.println(numberToCell(27));
        System.out.println(numberToCell(28));
        System.out.println(numberToCell(703));
        System.out.println(numberToCell(704));
        System.out.println(numberToCell(18278));
        System.out.println(numberToCell(18279));
        System.out.println();
        System.out.println(cellToNumber("1"));
        System.out.println(cellToNumber("26"));
        System.out.println(cellToNumber("AA"));
        System.out.println(cellToNumber("AB"));
        System.out.println(cellToNumber("AAA"));
        System.out.println(cellToNumber("AAB"));
        System.out.println(cellToNumber("ZZZ"));
        System.out.println(cellToNumber("AAAA"));
    }

    private static int cellToNumber(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            int result = 27;

            int toAdd = 26 * 26;
            for (int i = 2; i < s.length(); i++) {
                result += toAdd;
                toAdd *= 26;
            }

            int mult = 1;
            for (int i = s.length() - 1; i >= 0; i--) {
                result += mult * (s.charAt(i) - 'A');
                mult *= 26;
            }

            return result;
        }
    }

    private static String numberToCell(int n) {
        if (n <= 26) {
            return "" + n;
        } else {
            n -= 27;
            int digits = 2;
            int max = 26 * 26;
            while (n >= max) {
                n -= max;
                digits++;
                max *= 26;
            }
            
            return numberToCell(n, digits);
        }
    }

    private static String numberToCell(int n, int digits) {
        char[] value = new char[digits];

        for (int i = digits - 1; i >= 0; i--) {
            value[i] = (char) ('A' + (n % 26));
            n /= 26;
        }

        return new String(value);
    }
}
