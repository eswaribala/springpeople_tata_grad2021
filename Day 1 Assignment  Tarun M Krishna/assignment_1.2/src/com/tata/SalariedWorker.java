package com.tata;

public class SalariedWorker extends Worker{
    @Override
    public float payWorkers(int hours) {
        float pay=getSalaryrate()*hours;
        return pay;
    }
}
