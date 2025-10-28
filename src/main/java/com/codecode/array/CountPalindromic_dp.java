package com.codecode.array;

public class CountPalindromic_dp {

    public static void main(String[] args) {
        String s = "mnm";
        int count = 0;
        int i = 0, j = 2;
        countPalindromic(s, i, j);
    }

    private static void countPalindromic(String s, int start, int end) {
        int len = s.length();
        int count = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            count++;
        }

        for (int length = 2; length <= len; length++) {
            for (int i = 0; i < len - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (length == 2 || dp[i + 1][j - 1]) {
                        count++;
                    }
                }
            }
        }


    }


    private static boolean isPalindrome(String substring, int l, int k) {

        System.out.println("check if: " + substring.charAt(l) + "==" + substring.charAt(k));
        if (l >= k) {
            return true;
        }
        if (substring.charAt(l) != substring.charAt(k)) {
            return false;
        }

        return isPalindrome(substring, l + 1, k - 1);
    }
}
