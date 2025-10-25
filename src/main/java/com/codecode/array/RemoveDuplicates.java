package com.codecode.array;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
//        int[] arr = {10, 20, 20, 20, 30, 30};
        int[] arr = {10};
        int len = removeDuplicates(arr);
        System.out.println("Array is "+ Arrays.toString(arr));
    }

    private static int removeDuplicates(int[] arr) {


        int res = 0;
        int first = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != first) {
                arr[res] = arr[i];
                first = arr[i];
                res++;
            }


        }
        return res - 1;
    }
}
