package com.day1.exercises.e1.business;

import com.day1.exercises.e1.models.Product;

public interface ProductPriceCalculator {
    public double priceCalc(Product product, long qty);
}
