package com.tata.work.workers;

public class DailyWorker extends Worker{

    public DailyWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double pay(int WorkHours) {
        return WorkHours * getSalaryRate();
    }
}
