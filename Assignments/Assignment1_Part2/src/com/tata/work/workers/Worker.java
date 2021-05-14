package com.tata.work.workers;

public class Worker {
    private String Name;
    private double SalaryRate;

    public Worker(String name, double salaryRate) {
        Name = name;
        SalaryRate = salaryRate;
    }

    public double pay(int WorkHours){
        return 0;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getSalaryRate() {
        return SalaryRate;
    }

    public void setSalaryRate(double salaryRate) {
        SalaryRate = salaryRate;
    }
}
