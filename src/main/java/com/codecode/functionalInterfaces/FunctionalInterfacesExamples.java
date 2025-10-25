package com.codecode.functionalInterfaces;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalInterfacesExamples {

    public static void main(String[] args) {


        List<String> names = Arrays.asList("Alice", "Angelnna", "Aryabhatta", "Bob");
        Predicate<String> startsWithA = name -> name.startsWith("A");
        Collection<String> namesCollector = names
                .stream()
                .filter(startsWithA)
                .map(String:: toUpperCase)
                .collect(Collectors.toSet());
        namesCollector
                .forEach(System.out::println);


    }
}
