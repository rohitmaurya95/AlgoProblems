package com.maurya.rohit.practise.confluent;

public class MoveOp implements BinaryOperator{
    public static final String NAME = "MOVE";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void operate(Register x, Register y) {
        return;
    }
}
