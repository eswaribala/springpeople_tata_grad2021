package com.Tata.ShoppersDen.Entity;

import com.Tata.ShoppersDen.Dao.DatabaseAccess;

import com.Tata.ShoppersDen.Helpers.Pair;
import lombok.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public final class User extends Person{
    private String  email;
    private String  name;
    private long    phoneNo;
    private String  passWord;
    private String  address;
    private String  secondAddress;
    private String  secretQuestion;
    private String  userId;
    private Cart    cart;

    @Getter(AccessLevel.NONE)
    private DatabaseAccess databaseAccess;

    public void addToCart(Product product){
        cart.addToCart(product);
    }

    public double displayCartAmount(){
        return cart.displayAmount();
    }

    public Map<String,Integer> displayCartItems(){
        return cart.displayCartItems();
    }

    public Map<String, List<Product>> displayCartItemsDetail(){
        return cart.displayCartItemsDetail();
    }

    public double Bill(){
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(LocalDate.now());
        Map<String, Pair<Float,Integer>> products = new HashMap<>();
        Map<String, List<Product>> products_list = cart.displayCartItemsDetail();
        double Cost = 0;
        for(String key : products_list.keySet()) {
            products.put(key, new Pair<Float, Integer>(products_list.get(key).get(0).getPrice(), products_list.get(key).size()));
            Cost += (products.get(key).fst * products.get(key).snd);
        }
        transaction.setProduct(products);
        transaction.setUser(this.getUserId());
        if(databaseAccess.completeTransaction(transaction))
            return Cost;
        return 0.00;
    }

    public List<Product> getCategoryProducts(String categoryId){
        try{
            return databaseAccess.getCategoryProducts(categoryId);
        }
        catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }

    public List<Product> getAllProducts(){
        try{
            return databaseAccess.getAllProducts();
        }
        catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }
}
