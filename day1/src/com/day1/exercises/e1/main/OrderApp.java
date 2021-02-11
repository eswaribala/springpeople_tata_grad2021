package com.day1.exercises.e1.main;

import com.day1.exercises.e1.business.ProductPriceCalculator;
import com.day1.exercises.e1.business.ProductPriceCalculatorImpl;
import com.day1.exercises.e1.models.Product;

//import java.util.Scanner;

public class OrderApp {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);

        Product product = new Product();
        product.setProductId(1);
        product.setProductPrice(100);

        ProductPriceCalculator pCalc = new ProductPriceCalculatorImpl();
        System.out.println(pCalc.priceCalc(product,10));

    }
}
