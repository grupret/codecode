package com.codecode.strategy;

public class EuropeanTaxStrategy implements  BillingFactory{
    @Override
    public TaxStrategy createTaxStrategy() {
        return new VATaxStrategy();
    }
}
