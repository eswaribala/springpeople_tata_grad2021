package com.Tata.ShoppersDen.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Category {
    private String categoryId;
    private String categoryName;
}
