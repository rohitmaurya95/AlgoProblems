package com.maurya.rohit.practise.confluent;

public interface BinaryOperator {
    String getName();
    void operate(Register x, Register y);
}
