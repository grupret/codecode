package com.codecode.strategy;

public class VATaxStrategy implements TaxStrategy{
    @Override
    public double calculateTax(double amount) {
        return 0.21*amount;
    }
}
