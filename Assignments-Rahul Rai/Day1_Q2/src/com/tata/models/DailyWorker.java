package com.tata.models;

public class DailyWorker extends Worker {
    public DailyWorker(String name, float weeklyRate) {
        super(name,weeklyRate);
    }
    public float pay(int hours)
    {
        float weeklyPayment = hours * getSalaryRate();
        return weeklyPayment;
    }

}
