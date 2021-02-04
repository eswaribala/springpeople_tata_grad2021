package com.tata.shop;

import java.util.Scanner;

public class Main {

    public static float DetermineCost(int ProdNo){
        switch (ProdNo){
            case 1 : return 22.50f;
            case 2 : return 44.50f;
            case 3 : return 9.98f;
            default: return 0f;
        }
    }
    public static void main(String[] args) {
	// write your code here1
        Scanner scan = new Scanner(System.in);
        int prodNo;
        int prodQty;
        double Totalcost = 0.0;
        float cost;
        System.out.println("Press any character key to get Cost");
        System.out.println("Please enter prodNo and ProdQty");
        while (scan.hasNextInt()){
            // System.out.println("Enter Product Number : ");
            prodNo = scan.nextInt();
            // System.out.println("Enter Quantity Of Product : ");
            prodQty = scan.nextInt();
            cost = DetermineCost(prodNo);
            Totalcost+= (prodQty * cost);
        }
        System.out.println("Total cost of your inventory is : " + Totalcost);
    }
}
