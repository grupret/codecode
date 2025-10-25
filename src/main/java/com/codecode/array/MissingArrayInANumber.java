package com.codecode.array;

import java.util.Arrays;

public class MissingArrayInANumber {
    public static void main(String[] args) {
        int[] input = {1, 2, 4, 5, 6, 7, 8, 9};
//        1+2 =3
//        2(2+1)/2 =3

        int nums = input.length - 1;
        int totalSum = (input[nums] * (input[nums] + 1)) / 2;
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
        System.out.println("Missing Number is: " + (totalSum - sum));

    }
}
