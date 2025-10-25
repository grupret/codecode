package com.codecode.strategy;

public class IndianTaxStrategy implements BillingFactory{
    @Override
    public TaxStrategy createTaxStrategy() {
        return new GSTTaxStrategy();
    }
}
