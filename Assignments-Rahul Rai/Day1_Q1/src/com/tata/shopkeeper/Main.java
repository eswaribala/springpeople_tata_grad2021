package com.tata.shopkeeper;

import java.util.Scanner;

public class Main {

    static float price(int product)
    {
        switch(product) {
            case 1:
                return 22.50f;
            case 2:
                return 44.50f;
            case 3:
                return 9.98f;
            default:
                return 0.0f;
        }
    }


    public static void main(String[] args) {
        // write your code here :
        Scanner sc = new Scanner(System.in);
        float totalPrice = 0.0f;
        while(true)
        {
            System.out.println("Enter Product Number (0 to stop): ");
            int product = sc.nextInt();
            if(product == 0)
                break;
            System.out.println("Enter Quantity Sold : ");
            int quantity = sc.nextInt();
            totalPrice = totalPrice+(quantity*price(product));
        }
        System.out.println("Total Cost : "+totalPrice);
    }
}
