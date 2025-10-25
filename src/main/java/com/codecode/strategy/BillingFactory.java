package com.codecode.strategy;

public interface BillingFactory {
    TaxStrategy createTaxStrategy();
}
