package com.codecode.array;

public class CheckIfArrayIsSorted {

    public static void main(String[] args) {

//        int[] arr = {8, 12, 15};
//        int[] arr = {100};
        int[] arr = {100,20,200};
        boolean isSorted = isSorted(arr);
        if(isSorted)
            System.out.println("The array is sorted");
        else
            System.out.println("The array is not sorted");

    }

    private static boolean isSorted(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
