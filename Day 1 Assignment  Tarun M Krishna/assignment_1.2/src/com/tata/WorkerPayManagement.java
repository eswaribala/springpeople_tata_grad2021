package com.tata;

import java.util.Scanner;

public class WorkerPayManagement {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        Worker dailyWorker=new DailyWorker();
        System.out.println("DAILY WORKER");
        System.out.println("Enter Daily Worker Name:");
        dailyWorker.setName(s.next());
        System.out.println("Enter Salary Rate:");
        dailyWorker.setSalaryrate(s.nextFloat());
        System.out.println("Enter Work Hours");
        int hours=s.nextInt();
        System.out.println("Daily Worker Name:"+ dailyWorker.getName());
        System.out.println("Payment:"+dailyWorker.payWorkers(hours));


        Worker salariedWorker=new SalariedWorker();
        System.out.println("\nSALARIED WORKER");
        System.out.println("Enter Salaried Worker Name:");
        salariedWorker.setName(s.next());
        System.out.println("Enter Salary Rate:");
        salariedWorker.setSalaryrate(s.nextFloat());
        int hours1=40;
        System.out.println("Daily Worker Name:"+ salariedWorker.getName());
        System.out.println("Payment:"+salariedWorker.payWorkers(hours1));


    }
}
