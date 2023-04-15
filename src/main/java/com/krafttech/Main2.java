package com.krafttech;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("maxBlock(\"abbCCCddBBBxx\") = " + maxBlock("abbCCCddBBBxx"));

    }
     /*
    Given a string, return the length of the largest "block" in the string.
    A block is a run of adjacent chars that are the same.

    maxBlock("hoopla") → 2
    maxBlock("abbCCCddBBBxx") → 3
    maxBlock("") → 0
     */

    public static int maxBlock(String str) {
        int max = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            String result = str.substring(i, i + 1);
            String control = "";
            for (int j = i; j < n; j++) {
                if (result.equals(str.substring(j, j + 1))) {
                    control += str.substring(j, j + 1);
                } else break;
                max = Math.max(control.length(), max);
            }
        }
        return max;
    }
}
