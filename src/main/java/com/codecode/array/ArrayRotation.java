package com.codecode.array;

import org.springframework.data.relational.core.sql.In;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.rotate;

public class ArrayRotation {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        int[] inputDuplicate = new int[]{1, 2, 3, 4, 5, 6};
        int rotateDist = 2;
        int[] output = new int[]{5, 6, 1, 2, 3, 4};

//        2 1 6 5 4 3
//        3 4 5 6 1 2

//
//        1 2 3 4 5 6
//        4 3 2 1 6 5
//        5 6 1 2 3 4
        rotate(input, rotateDist);
        input.stream().forEach(System.out::print);
        rotateD(inputDuplicate, rotateDist);
    }


    private static void rotateD(int[] inputDuplicate, int rotateDist) {
        int totLen = inputDuplicate.length;

        //0..totLen-1-rotateDist
        int temp;
        int i = 0;
        int j = totLen - 1 - rotateDist;
        while (i <= j) {
            temp = inputDuplicate[i];
            inputDuplicate[i] = inputDuplicate[j];
            inputDuplicate[j] = temp;
            i++;
            j--;

        }
        //totLen-rotateDist .. len -1
        int k = totLen - rotateDist;
        int l = totLen - 1;
        while (k <= l) {
            temp = inputDuplicate[k];
            inputDuplicate[k] = inputDuplicate[l];
            inputDuplicate[l] = temp;
            k++;
            l--;
        }


        int x = 0;
        int y = totLen - 1;
        while (x <= y) {
            temp = inputDuplicate[x];
            inputDuplicate[x] = inputDuplicate[y];
            inputDuplicate[y] = temp;
            x++;
            y--;
        }
        System.out.println("\nNew Array is\n" + Arrays.toString(inputDuplicate));
    }
}