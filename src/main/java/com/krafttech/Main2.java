package com.krafttech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        String str="";

        System.out.println( longestPalindrome(str));
        System.out.println(longestPalindrome2(str));
    }

    /**
     * Given a string s, return the longest palindromic substring in s.
     * Example 1:
     * <p>
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * Example 2:
     * <p>
     * Input: s = "cbbd"
     * Output: "bb"
     * <p>
     * input : "abccbs"
     * output:bccb
     */

    public static String longestPalindrome(String str) {
        if (str.length() == 0) return "";
        if (str.length() == 1) return str;

        List<String> allSubs = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String newStr = str.substring(i, j);
                allSubs.add(newStr);
            }
        }

        List<String> allPalindromeSubs = new ArrayList<>();

        for (String allSub : allSubs) {
            if (isPalindrome(allSub)) {
                allPalindromeSubs.add(allSub);
            }
        }

        List<Integer> lengthOfSubs = new ArrayList<>();

        for (String allPalindromeSub : allPalindromeSubs) {
            lengthOfSubs.add(allPalindromeSub.length());
        }

        int max = Collections.max(lengthOfSubs);

        return allPalindromeSubs.get(lengthOfSubs.indexOf(max));

    }

    //abbc
    public static String longestPalindrome2(String str) {
        String palindrome = "";
        String result = "";
        boolean bl = false;
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                bl = reverse(str.substring(i, j + 1));
                palindrome = str.substring(i, j + 1);
                if (bl && palindrome.length() > max) {
                    max = palindrome.length();
                    result = palindrome;
                }
            }

        }
        return result;
    }

    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static boolean reverse(String str) {
        String revers = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            revers += str.charAt(i);
        }
        return revers.equals(str);
    }

}
