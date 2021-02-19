package com.Tata.ShoppersDen.Entity;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Data
public class Cart {
    private String cartId;
    List<Product> products;

    public Cart(){
        cartId = "cartNo" + new Random().nextInt(Integer.MAX_VALUE);
        products = new ArrayList<>();
    }

    public void addToCart(Product product){
        products.add(product);
    }
    public double displayAmount(){
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public Map<String,Integer> displayCartItems(){
        return products.stream().collect(groupingBy(Product::getProductId, summingInt(a -> 1)));
    }

    public Map<String,List<Product>> displayCartItemsDetail(){
        return products.stream().collect(groupingBy(Product::getProductId,Collectors.toCollection(ArrayList::new)));
    }

}
