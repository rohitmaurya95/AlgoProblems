package com.maurya.rohit.practise.decoratorPattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        FineCalculator baseFineCalculator = new BaseFineCalculator();
        FineCalculator fineCalculator = new LostFine(new DamageFine(baseFineCalculator));
        System.out.println(fineCalculator.getFine());
    }
}
