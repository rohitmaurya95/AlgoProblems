package com.maurya.rohit.practise.decoratorPattern;

public class FineDecorator implements FineCalculator{
    protected FineCalculator fineCalculator;

    public FineDecorator(FineCalculator fineCalculator) {
        this.fineCalculator = fineCalculator;
    }

    @Override
    public double getFine() {
        return fineCalculator.getFine();
    }
}
