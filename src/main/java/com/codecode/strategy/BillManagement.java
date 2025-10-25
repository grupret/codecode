package com.codecode.strategy;

public class BillManagement {

    public static void main(String[] args) {
    //instantiate singleton class
        int amount = 100;

        BillingFactory factory = new IndianTaxStrategy();
        TaxStrategy baseTax = factory.createTaxStrategy();

        boolean addServiceTax=true;
        if(addServiceTax){
            baseTax = new ServiceTaxDecorator(baseTax);
        }
//        double tax = baseTax.calculateTax(amount);
//        Biller bill = new Biller(100);
//        double totalBillValue = bill.getBilledAmount();
        Biller bill = new Biller(amount, baseTax);
        double totalBillValue = bill.getBilledAmount();

        System.out.println("Total Bill Value is " + totalBillValue);

    }

}


class Biller{

    int amount;
    TaxStrategy taxStrategy;

    public Biller(int amount, TaxStrategy taxStrategy){
        this.amount=amount;
        this.taxStrategy= taxStrategy;
    }

    public double getBilledAmount(){
//        int tax = (21 * amount)/100;
//        TaxStrategy tax = new GSTTaxStrategy();
//        double taxAmount = tax.calculateTax(amount);
        double tax = taxStrategy.calculateTax(amount);
        System.out.println("Tax is "+ tax);
        return amount + tax;
    }
}


