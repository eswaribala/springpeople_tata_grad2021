package com.tata.models;

public class Worker {
    private String name;
    private float salaryRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalaryRate() {
        return salaryRate;
    }

    public void setSalaryRate(float salaryRate) {
        this.salaryRate = salaryRate;
    }

    public Worker(String name, float salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }
    public float pay(int hours)
    {
        return 0.0f;
    }
}
