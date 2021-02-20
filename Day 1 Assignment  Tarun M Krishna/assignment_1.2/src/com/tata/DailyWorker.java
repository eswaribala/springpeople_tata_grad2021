package com.tata;

public class DailyWorker extends Worker{
    @Override
    public float payWorkers(int hours) {
        float pay=getSalaryrate()*hours/24;
        return pay;
    }
}
