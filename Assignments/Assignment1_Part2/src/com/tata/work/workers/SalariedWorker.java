package com.tata.work.workers;

public class SalariedWorker extends Worker {
    public SalariedWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double pay(int WorkHours) {
        return Math.min(WorkHours,40) * getSalaryRate();
    }
}
