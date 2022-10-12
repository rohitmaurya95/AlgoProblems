package com.maurya.rohit.practise.decoratorPattern;

public class BaseFineCalculator implements FineCalculator {
    @Override
    public double getFine() {
        return 10;
    }
}
