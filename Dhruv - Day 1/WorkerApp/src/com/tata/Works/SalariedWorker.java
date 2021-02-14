package com.tata.Works;

public class SalariedWorker extends Worker {
    int hours = 40;
    int salaryRate;

    public int getSalaryRate() {
        return salaryRate;
    }

    public void setSalaryRate(int salaryRate) {
        this.salaryRate = salaryRate;
    }

    void Pay()
    {
        super.display();
        System.out.println("The Pay of Salaried Worker is: " + salaryRate*hours);
    }
}
