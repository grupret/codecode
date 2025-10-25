package com.codecode.array;

import java.util.Arrays;

public class TrappedWater {
    public static void main(String[] args) {


//        int arr[] = {3, 0, 1, 2, 5};
//        int arr[] = {5, 0, 6, 2, 3};
        int arr[] = {0, 0, 6, 2, 3};
        int water = getTrappedWater(arr);
        System.out.println("Amont of water " + water);
    }

    private static int getTrappedWater(int[] arr) {

        int[] left = new int[arr.length];
        left[0] = arr[0];
        int[] right = new int[arr.length];
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            if (left[i - 1] < arr[i]) {
                left[i] = arr[i];
            } else {
                left[i] = left[i - 1];
            }
        }
        for (int j = arr.length - 2; j >= 0; j--) {
            if (right[j + 1] > arr[j]) {
                right[j] = right[j + 1];
            } else {
                right[j] = arr[j];
            }
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        int sum = 0;
        for (int k = 0; k < arr.length; k++) {

            sum = sum + (Math.min(left[k], right[k]) - arr[k]);
        }

        return sum;
    }
}
