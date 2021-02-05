package com.day1.exercises.e2.utility;

import com.day1.exercises.e2.models.DailyWorker;
import com.day1.exercises.e2.models.SalariedWorker;
import com.day1.exercises.e2.models.Worker;

public class PayCalculatorImpl{

    public static double calcPay(Worker worker, int hours) {
        if(worker instanceof DailyWorker) {
            return worker.getSalaryRate() * ((DailyWorker) worker).getDaysWorked() * hours;
        } else if (worker instanceof SalariedWorker){
            return worker.getSalaryRate() * 40 * hours;
        }

        return 0;
    }
}
