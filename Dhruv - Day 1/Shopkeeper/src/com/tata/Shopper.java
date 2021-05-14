package com.tata;

import java.util.Scanner;

import static java.lang.System.exit;


public class Shopper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float Price = 0;
        while (true) {
            System.out.println("Product 1 - 22.50");
            System.out.println("Product 2 - 44.50");
            System.out.println("Product 3 - 9.98");
            System.out.println("Enter 4 to Exit program");
            System.out.println("Enter product number and Quantity Sold");
            int prod_no = sc.nextInt();
            int qty = sc.nextInt();
            switch (prod_no) {
                case 1:
                    Price += (float) qty * 22.5f;
                    break;
                case 2:
                    Price += (float) qty * 44.5f;
                    break;
                case 3:
                    Price += (float) qty * 9.98f;
                    break;
                case 4:
                    exit(0);
                default:
                    System.out.println("Reenter Valid Product Number");

            }
            System.out.println("Total Price = "+Price);
        }


    }
}


