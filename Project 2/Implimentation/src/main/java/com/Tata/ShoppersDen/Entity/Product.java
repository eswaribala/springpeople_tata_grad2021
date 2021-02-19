package com.Tata.ShoppersDen.Entity;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Product extends Category{
    private String      productId;
    private String      productName;
    private String      productDesc;
    private float         price;
    private int         quantity;
    private LocalDate   expDate;
    private String      imageUrl;
}
