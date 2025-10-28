package com.codecode.dynamicprogramming;

public class LongestCommonSubsequence {


    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        int m = 6, n = 6;
        int memo[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println("Longest Sequence is length " + findLCS(memo, s1, s2, m, n));
    }

    private static int findLCS(int[][] memo, String s1, String s2, int m, int n) {

        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (m == 0 || n == 0) {
            memo[m][n] = 0;
        } else if (s1.charAt(m-1) == s2.charAt(n-1)) {
            memo[m][n] = 1 + findLCS(memo, s1, s2, m - 1, n - 1);
        } else {
            memo[m][n] = Math.max(findLCS(memo, s1, s2, m - 1, n), findLCS(memo, s1, s2, m, n - 1));
        }
        return memo[m][n];
    }

}
