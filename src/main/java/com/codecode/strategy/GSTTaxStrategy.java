package com.codecode.strategy;

public class GSTTaxStrategy implements TaxStrategy{
    @Override
    public double calculateTax(double amount) {
        return 0.18*amount;
    }
}
