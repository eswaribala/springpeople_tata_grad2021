package com.tata.Works;

public class DailyWorker extends Worker{
    int salaryrate;

    public int getSalaryrate() {
        return salaryrate;
    }

    public void setSalaryrate(int salaryrate) {
        this.salaryrate = salaryrate;
    }

    void Pay(int days)
    {
        super.display();
        System.out.println("The Pay of DailyWorker is: " + days*salaryrate);
    }
}
