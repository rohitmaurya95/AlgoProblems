package com.maurya.rohit.Problems.BinarySearch;

import java.util.ArrayList;

public class PowerFunction {
    public static long pow(long x, long n, long d) {
        if(x==0){
            return 0;
        } else if(n==0){
            return 1;
        } else if(n==1){
            return x<0? (x+d)%d : x;
        }
        if(n%2==0) {
            x = x<0? -1*x:x;
            long temp = pow(x, n / 2, d);
            return (temp%d * temp%d)%d;
        }
        else {
            x = x<0? (x+d)%d : x;
            return (pow(x, n - 1, d) % d * x % d) % d;
        }

    }

    public static void main(String[] args) {
        System.out.println(pow(-1, 2, 10));
    }
}
