package com.codecode.array;

public class LargestElement {

    public static void main(String[] args) {

        int[] arr = {5, 8, 20, 10};

        int largest = findLargest(arr);
        System.out.println("largest num is " + largest);
    }

    private static int findLargest(int[] arr) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
