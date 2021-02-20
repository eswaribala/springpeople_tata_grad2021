package com.tata;


import java.util.Scanner;

public class ShopKeeper {
    public static void main(String[] args) {
        float price = 0;
        boolean loop = true;
        Scanner s = new Scanner(System.in);
        System.out.println("Products \tPrice");
        System.out.println("Product 1\t22.50 ");
        System.out.println("Product 2\t44.50");
        System.out.println("Product 3\t9.98");
        System.out.println("\n");
        System.out.println("Enter Product number and quantity:");
        System.out.println("Enter -1 -1 to stop entering.");
        while (loop) {
            int product_number = s.nextInt();
            int quantity = s.nextInt();
            switch (product_number) {
                case 1:
                    price += (float) 22.50 * quantity;
                    break;
                case 2:
                    price += (float) 44.50 * quantity;
                    break;
                case 3:
                    price += (float) 9.98 * quantity;
                    break;
                case -1:
                    loop=false;
                    break;
                default:
                    System.out.println("Enter Valid Product Number.");
            }
        }
        System.out.println("Total Price:" + price);
    }

}
