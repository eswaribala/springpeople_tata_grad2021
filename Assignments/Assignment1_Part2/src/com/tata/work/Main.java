package com.tata.work;

import com.tata.work.workers.DailyWorker;
import com.tata.work.workers.SalariedWorker;
import com.tata.work.workers.Worker;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Worker S_worker1 = new SalariedWorker("S1",40);
        Worker S_worker2 = new SalariedWorker("S2",50);
        Worker S_worker3 = new SalariedWorker("S3",60);
        Worker D_worker1 = new DailyWorker("D1",25);
        Worker D_worker2 = new DailyWorker("D2",35);
        Worker D_worker3 = new DailyWorker("D3",45);

        System.out.println(S_worker1.getName() + " salary is " + S_worker1.pay(50));
        System.out.println(S_worker2.getName() + " salary is " + S_worker2.pay(25));
        System.out.println(S_worker3.getName() + " salary is " + S_worker3.pay(15));
        System.out.println(D_worker1.getName() + " salary is " + D_worker1.pay(45));
        System.out.println(D_worker2.getName() + " salary is " + D_worker2.pay(30));
        System.out.println(D_worker3.getName() + " salary is " + D_worker3.pay(60));
    }
}
