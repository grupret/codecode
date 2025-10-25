package com.codecode.strategy;

public class ServiceTaxDecorator extends TaxDecorator{

    public ServiceTaxDecorator(TaxStrategy strategy) {
        super(strategy);
    }

    @Override
    public double calculateTax(double amount) {
        double baseTax= wrappedStrategy.calculateTax(amount);
        double serviceTax = 0.05 * amount;
        System.out.println("Service Addon tax is added "+ serviceTax);
        return serviceTax + baseTax;
    }
}
