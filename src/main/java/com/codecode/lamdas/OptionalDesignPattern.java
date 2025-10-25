package com.codecode.lamdas;

import java.util.Optional;


//TODO: 1. Return a reference id the value will always exist
//TODO: 2. Return an Optional<T> if the value may or may not exists
//TODO: 3. Do not use Optional<T> for fields
//TODO: 4. Do not use Optional<T> for netrhord parameters
public class OptionalDesignPattern {
    public static Optional<String> getName(long id) {
        if (id == 0) {
            return Optional.empty();
        }
        return Optional.of("some name");

    }

    public static void main(String[] args) {
//        System.out.println(getName(1).toUpperCase());
        Optional<String> result = getName(0);
        //will blow up if not found
//        System.out.println(result.get());

        if (result.isPresent()) {
            System.out.println(result.orElseThrow());
        } else {
            System.out.println("No Body-1");
        }
        System.out.println(result.orElse("No Body-2"));

    }
}
//Code should reveal its intention


