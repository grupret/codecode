package com.codecode.array;

public class MaxSubArraySum {

    public static void main(String[] args) {
        int[] input = {2, 3, -9, 5, 6, -18, 1, 2, 12};
        // 2 (3,5) (5, 2) (7,5) (13, 6) (13,4)(5,1)(7,2)
        // 2, 5, 5,7, 13, ,13,

        System.out.println("Max Sum is: " + maxSubArraySum(input));

    }

    private static int maxSubArraySum(int[] input) {

        int max = 0;
        int localMax = input[0];

        for (int i = 1; i < input.length; i++) {
            localMax = Math.max(localMax + input[i], input[i]);
            max = Math.max(max, localMax);
        }
        return max;
    }
}
