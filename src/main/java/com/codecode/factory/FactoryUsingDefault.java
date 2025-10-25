package com.codecode.factory;


interface  Player{

    Pet getPlay(); // Factory method
    default void play(){
        System.out.println("I like playing...");
        System.out.println("playing with " + getPlay());
    }
}

interface Pet{}

class Dog implements Pet{ }
class Cat implements Pet{ }

class DogLover implements Player{

    @Override
    public Pet getPlay() {
        return new Dog();
    }
}
class CatLover implements Player{

    @Override
    public Pet getPlay() {
        return new Cat();
    }
}
public class FactoryUsingDefault {

    public static void callPlay(Player player){
        player.play();
    }


    //Factory  - an abstraction to create an Object
    //Method - inheritance hierarchy where we can override a method to provide  an alternative implementation that we return
    // Typically we have base class (abstract) and derived classes that override the factory method
//    in general interfaces are better than abstract method

    public static void main(String[] args) {

        callPlay(new DogLover());



    }
}
