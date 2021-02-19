package com.Tata.ShoppersDen.Entity;


import com.Tata.ShoppersDen.Helpers.Pair;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class Transaction {
    private LocalDate       transactionDate;
    private Map<String, Pair<Float,Integer>> product;
    private String           user;
}
