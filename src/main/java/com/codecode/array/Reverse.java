package com.codecode.array;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {

//        int[] arr = {10, 5, 7, 30};
//        int[] arr = {10, 5, 7};
        int[] arr = {10};

        System.out.println("Reverse Array is " +

                Arrays.toString(reverse(arr)));
        System.out.println("Reverse Array is " +

                Arrays.toString(reverseInplace(arr)));
    }

    private static int[] reverse(int[] arr) {

        int[] revArr = new int[arr.length];
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            revArr[index] = arr[i];
            index++;
        }
        return revArr;
    }

    private static int[] reverseInplace(int[] arr) {

        int i = 0;
        int j = arr.length - 1;
        int swap = -1;
        while (i < j) {

            swap = arr[i];
            arr[i] = arr[j];
            arr[j] = swap;
            i++;
            j--;
        }
        return arr;

    }

}
