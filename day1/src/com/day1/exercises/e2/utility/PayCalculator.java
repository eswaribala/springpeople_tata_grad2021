package com.day1.exercises.e2.utility;

import com.day1.exercises.e2.models.Worker;

public interface PayCalculator {
    public double calcPay(Worker worker, int hours);
}
