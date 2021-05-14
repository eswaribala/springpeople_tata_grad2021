package com.tata.Works;

import java.util.Random;
import java.util.Scanner;

public class WorkerApp {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        DailyWorker w1=new DailyWorker();
        System.out.println("Enter the name of the DailyWorker: ");
        w1.setName(sc.next());
        w1.setSalaryrate(new Random().nextInt(1000));
        System.out.println("Enter the number of days worked: ");
        w1.Pay(sc.nextInt());

        SalariedWorker w2 = new SalariedWorker();
        System.out.println("Enter the name of the SalariedWorker: ");
        w2.setName(sc.next());
        w2.setSalaryRate(new Random().nextInt(1000));
        w2.Pay();
    }
}
