package com.maurya.rohit.practise.decoratorPattern;

public class LostFine extends FineDecorator{
    public LostFine(FineCalculator fineCalculator) {
        super(fineCalculator);
    }

    @Override
    public double getFine() {
        return super.getFine() + 100;
    }
}
