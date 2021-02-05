package com.day1.exercises.e2.main;

import com.day1.exercises.e2.models.DailyWorker;
import com.day1.exercises.e2.models.Worker;

import static com.day1.exercises.e2.utility.PayCalculatorImpl.calcPay;

public class PaymentModule {
    public static void main(String[] args) {
        DailyWorker dailyWorker = new DailyWorker();
        dailyWorker.setEmpId(1);
        dailyWorker.setName("xyz");
        dailyWorker.setSalaryRate(20);
        dailyWorker.setDaysWorked(5);

        System.out.println(calcPay(dailyWorker, 10));
    }

}
