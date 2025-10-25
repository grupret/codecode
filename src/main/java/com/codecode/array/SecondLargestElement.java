package com.codecode.array;

public class SecondLargestElement {
    public static void main(String[] args) {

//        int arr[] = {10, 5, 8, 2};
        int arr[] = {20,10,20,8,12};
        int secondLargest = getSecondLargest(arr);
        System.out.println(
                "second largest " + secondLargest
        );
    }

    private static int getSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];

            } else if (arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
