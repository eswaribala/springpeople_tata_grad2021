package com.tata.models;

public class SalariedWorker extends Worker{
    public SalariedWorker(String name, float hourlyRate) {
        super(name,hourlyRate);
    }
    public float pay(int hours)
    {
        float weeklyPayment = 40 * getSalaryRate();
        return weeklyPayment;
    }
}
