package com.codecode.array;

public class MaxConsecutiveOne {
    public static void main(String[] args) {

//        int[] arr = {0, 1, 1, 0, 1, 1, 1};
        int arr[] = {0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1};
        int res = countMaxOne(arr);
        System.out.println("Max no of 1 is " + res);
    }

    private static int countMaxOne(int[] arr) {

        int curr = 0;
        int res = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {

                curr = 0;
            } else {
                curr++;
                res = Math.max(res, curr);
            }

        }

        return res;
    }


}
