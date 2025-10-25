package com.codecode.lightstrategy;

import java.util.List;
import java.util.function.Predicate;

public class LightStrategy {

//Strategy Pattern

    // We have an algorithm and we want to vary a small part of it
    // java 1.1. we had and anonymous inner class
    //You would create an interface for strategy
    // We create a bunch of classed or anonymous inner classes to implements that interface
    //Step back  what is really a strategy ?
    // it is definitely not a class
    // Fundamentally strategy is a function
    // Naturally strategy can be implemented using the lambdas


    public static int totalValues(List<Integer> values) {
        int result = 0;
        for (var value : values) {
            result += value;
        }
        return result;

    }

    public static int totalEvenValues(List<Integer> values) {
        int result = 0;
        for (var value : values) {
            if (value % 2 == 0)
                result += value;
        }
        return result;

    }

    public static void main(String[] args) {
        var values = List.of(11, 23, 32, 23, 24, 15, 21);
        int resultTotal = totalValues(values);
        System.out.println("Result Total " + resultTotal);
        int resultTotalEven = totalEvenValues(values);
        System.out.println("Result Even Total " + resultTotalEven);
        System.out.println("Result Total " + totalValuesRefactored(values, e -> true));
        System.out.println("Result Total Even " + totalValuesRefactored(values, e -> e % 2 == 0 ));
        System.out.println("Result Total Odd " + totalValuesRefactored(values, e -> e % 2 != 0 ));

        //Refactor before you add a feature or after you add a  feature but not a between
        //programming is 10% skill 90 % discipline
        //Commit ofter and commit in small proportion
        //frequent commit make the cost of undo near zero
    }

    private static int totalValuesRefactored(List<Integer> values, Predicate<Integer> selector) {
    return values
            .stream()
            .filter(selector)
            .mapToInt(e-> e)
            .sum();
    }

}
