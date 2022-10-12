package com.maurya.rohit.practise.decoratorPattern;

public class DamageFine extends FineDecorator {
    public DamageFine(FineCalculator fineCalculator) {
        super(fineCalculator);
    }

    @Override
    public double getFine() {
        return super.getFine() + 50;
    }
}
