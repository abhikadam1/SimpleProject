package com.example.SimpleProject.Service;

import com.example.SimpleProject.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ProductService
{
    List<Product> products = new ArrayList<>( Arrays.asList(
            new Product(101, "Iphone", 150000),
            new Product(102, "One Plus", 45000),
            new Product(103, "Nothing Phone", 35000),
            new Product(104, "Samsung", 115000)
        ));
    public List<Product> getProducts()
    {
            return  products;
    }

    public Product getProductById(int prodId) {
         return products.stream()
                 .filter(p -> p.getProductId() == prodId)
                 .findFirst().orElse(new  Product(0, "No Product Found", 0));
    }

    public void addProduct(Product prod)
    {
        products.add(prod);
    }
    public Product updateProduct(Product prod)
    {
        int index = -1;
        for ( int i = 0; i < products.size(); i++ )
            if(products.get(i).getProductId() == prod.getProductId())
                index = i;

        if (index == -1)
            return new  Product(0, "No Product Found", 0);

        System.out.println(prod + " " + index);
        return products.set(index, prod);
    }

    public Product deleteProduct(int prodId)
    {
        int index = -1;
        for ( int i = 0; i < products.size(); i++ )
            if(products.get(i).getProductId() == prodId)
                index = i;

        if (index == -1)
            return new  Product(0, "No Product Found", 0);

        return products.remove(index);
    }
}
