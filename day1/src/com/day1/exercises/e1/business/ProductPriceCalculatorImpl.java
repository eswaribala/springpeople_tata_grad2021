package com.day1.exercises.e1.business;

import com.day1.exercises.e1.models.Product;

public class ProductPriceCalculatorImpl implements ProductPriceCalculator{

    @Override
    public double priceCalc(Product product, long qty) {
        int productId = product.getProductId();
        switch(productId){
            case 1:
                return (qty*22.5);
            case 2:
                return (qty*44.5);
            case 3:
                return (qty*9.98);
        }
        return 0;
    }
}
