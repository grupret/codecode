package com.codecode.lamdas;

import java.util.List;

public class Iterator {

    public static void main(String[] args) {

        var names = List.of("Tom", "Jerry", "Bob", "Dal");

        for (var name : names) {
            System.out.println("Name is " + name);
        }

        names.forEach(System.out::println);
//Statement will cause a mutation ( a side effect and go away)
//In functional interfaces/ programming we're often using an expression instead of the statements

        System.out.println("================= Take 2 ===========================");


        names
                .stream()
                .takeWhile(name -> !name.equals("Bob"))
                .forEach(System.out::println);
// take while is functional programming implementation of imperative type

        System.out.println("================= Take 3 ===========================");
names
        .stream()
        .limit(3)
        .forEach(System.out::println);
    }
}
