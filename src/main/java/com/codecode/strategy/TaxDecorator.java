package com.codecode.strategy;

public abstract class TaxDecorator implements TaxStrategy {

    public TaxStrategy wrappedStrategy;

    public TaxDecorator(TaxStrategy strategy){
        wrappedStrategy=strategy;
    }

    public abstract double calculateTax(double amount);
}
