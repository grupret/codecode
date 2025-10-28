package com.codecode.array;

public class CountPalindromic_bruteforce {

    public static void main(String[] args) {
        String s = "mnm";
        int count = 0;
//
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j))) {
                    count++;
                }
            }
        }
        System.out.println("No of Palindrome: " + count);
    }

    private static boolean isPalindrome(String substring) {
        if (substring.length() == 1) {
            return true;
        }
        int k = 0;
        int l = substring.length() - 1;
        while (k < l) {
            if (substring.charAt(k) != substring.charAt(l)) {
                return false;
            }
            k++;
            l--;
        }
        return true;
    }
}
