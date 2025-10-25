package com.codecode.strategy;

public interface PaymentStrategy {

    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Payment for Credit Card");
    }

}


class PayPalPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Payment for PayPal Card");
    }
}

class Checkout {

    private PaymentStrategy strategy;

    Checkout(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
}

