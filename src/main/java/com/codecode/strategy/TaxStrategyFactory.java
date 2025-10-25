package com.codecode.strategy;

public class TaxStrategyFactory {

    public static TaxStrategy getStrategy(String type) throws IllegalAccessException {

        switch (type.toUpperCase()) {

            case "GST":
                return new GSTTaxStrategy();
            case "VAT":
                return new VATaxStrategy();
            default:
                throw new IllegalAccessException("Unknown tax exception");


        }
    }

}
