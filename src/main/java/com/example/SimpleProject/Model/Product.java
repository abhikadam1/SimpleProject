package com.example.SimpleProject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int productId;
    private String productName;
    private double price;

//    public Product(String name, double price, int quantity) {
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
//    }

}
