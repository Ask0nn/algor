package com.ask0n;

public class MathFunctions {
    public double funMax(double xDelta, int num) {
        final double first = customLog((1 - num) / Math.sin(xDelta + num), 21);
        final double second = Math.abs(Math.cos(xDelta) / num);
        return Math.max(first, second);
    }

    public double funMin(double xDelta, int num) {
        final double first = customLog((1 - num) / Math.cos(xDelta - num), 21);
        final double second = Math.sin(xDelta) / num;
        return Math.min(first, second);
    }

    private double customLog(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }
}
