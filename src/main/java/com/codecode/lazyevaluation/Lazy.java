package com.codecode.lazyevaluation;

import java.util.function.Supplier;

public class Lazy {


    public static int compute(int number) {
        System.out.println("slow operation");
        return number;
    }

    public static void operate(int value) {
        if (Math.random() > 0.5) {
            System.out.println("use the value " + value);
        } else {
            System.out.println("continue without using the value");
        }
    }

    public static void operateNormalOrder(Supplier<Integer> value) {
        if (Math.random() > 0.5) {
            System.out.println("use the value \n" + value.get());
        } else {
            System.out.println("continue without using the value \n");
        }
    }

    public static void main(String[] args) {
        //Applicative Order -> wvaluation is in order of call or application
        System.out.println("============================= Applicative Order ===============================================");
        operate(compute(20)); // Sometime it uses the value sometimes it doent as well
        //Normal Order -> extreme lazy
        System.out.println("============================= Normal Order =====================================================");
        operateNormalOrder(() -> compute(20));
    }
}
