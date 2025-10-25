package com.codecode.recurssion;

import static org.locationtech.jts.util.Debug.print;

public class Print {


    public static void printHead(int n) {

        if (n == 0) {
            return;
        }
        System.out.printf(" Printing From Head %d \n", n);
        printHead(n - 1);
    }

    public static void printTail(int n) {

        if (n == 0) {
            return;
        }
        printTail(n - 1);
        System.out.printf(" Printing from Tail %d \n", n);
    }


    private static long factorial(int n) {

        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static long factorialTailRecurrsive(int n, long k) {

        if (n == 0 || n == 1) {
            return k;
        }
        return factorialTailRecurrsive(n - 1, k * n);
    }

    private static int sum(int n, int k) {
        if (n == 0) {
            return k;
        }
        return sum(n - 1, k + n);
    }


    private static boolean isPalindrome(String str, int start, int end) {

        if (start >= end) {
            return true;
        }

        return ((str.charAt(start) == str.charAt(end)) && isPalindrome(str, start + 1, end - 1));

    }

    private static int sumOfDigit(int n, int sum) {

        if (n <= 0) {
            return sum;
        }

        return sumOfDigit(n / 10, sum + (n % 10));
    }

    private static int cutTheRope(int n, int a, int b, int c) {

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return -1;
        }


        int res = Math.max((Math.max(1 + cutTheRope(n - a, a, b, c), 1 + cutTheRope(n - b, a, b, c))), 1 + cutTheRope(n - c, a, b, c));
        if (res == -1) {
            return -1;
        }
        return res + 1;

    }

    private static int leastCommonSubsequence(String s1, String s2, int m, int n) {

        if (m < 0 || n < 0) {
            return 0;
        }

        if (s1.charAt(m) == s2.charAt(n)) {
            return 1 + leastCommonSubsequence(s1, s2, m - 1, n - 1);
        }

        int res = Math.max(leastCommonSubsequence(s1, s2, m - 1, n), leastCommonSubsequence(s1, s2, m, n - 1));
        if (res == -1) {
            return 0;
        } else {
            return res;
        }
    }


    public static void main(String[] args) {
//        int n = 23;
        int n = 9;
//        int a = 2, b = 5, c = 1;
        int a = 2, b = 2, c = 2;
        int k = 0;
        long l = 1;
        int sum = 0;
        String s1 = "ABY";
        String s2 = "ABXY";

//        printHead(n);
//        printTail(n);

//        System.out.println("Factorial Head Recursion " + factorial(n));
//        System.out.println("Factorial Tail Recursion " + factorialTailRecurrsive(n, l));
//        System.out.println("Sum of natural number " + sum(n, k));
//        System.out.println("isPallendrome " + isPalindrome("acgdbca", 0, 4));
//        System.out.println("Sum of digit "+ sumOfDigit(n, sum));
//        System.out.println(cutTheRope(n, a, b, c));
        System.out.println(leastCommonSubsequence(s1, s2, 2, 3));
    }


}
