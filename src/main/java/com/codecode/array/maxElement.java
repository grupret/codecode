package com.codecode;

public class maxElement {

    public static void main(String[] args) {
        int arr[]= {2,4,6,3,5,7,9,1,8};
        int max=Integer.MIN_VALUE;
        int max_index=0;
        for(int i=0;i<arr.length;i++){
            if(max < arr[i]) {
                max = arr[i];
                max_index=i;

            }
        }
        Result result = new Result(max, max_index);
        System.out.println("max element is "+ result.max() + " at index " + result.max_index());
    }

    private record Result(int max, int max_index) {
    }
}
