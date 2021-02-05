package com.tata.utility;

import com.tata.models.DailyWorker;
import com.tata.models.SalariedWorker;
import com.tata.models.Worker;

import java.util.Scanner;

public class SalaryApp {

    public static void main(String[] args) {
	// write your code here :
        Scanner sc = new Scanner(System.in);
        String name;
        float rate;
        int hours;
        System.out.println("Daily Worker Name : ");
        name = sc.nextLine();
        System.out.println("Daily Worker Hourly rate : ");
        rate = sc.nextFloat();
        System.out.println("Number of hours : ");
        hours = sc.nextInt();
        Worker dailyWorker = new DailyWorker(name,rate);
        System.out.println("Weekly pay of "+dailyWorker.getName()+" is "+dailyWorker.pay(hours));

        System.out.println("Salaried Worker Name : ");
        String name1 = sc.next();
        System.out.println("Salaried Worker Hourly rate : ");
        rate = sc.nextFloat();
        System.out.println("Number of hours : ");
        hours = sc.nextInt();
        Worker salariedWorker = new SalariedWorker(name1,rate);
        System.out.println("Weekly pay of "+salariedWorker.getName()+" is "+salariedWorker.pay(hours));

    }
}
