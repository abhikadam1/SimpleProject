package com.example.SimpleProject.Controller;

import com.example.SimpleProject.Model.Product;
import com.example.SimpleProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    TempController tempController;

    @RequestMapping("/TEST")
    public String getTest() {
        return  tempController.temp111();
    }
    @RequestMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @RequestMapping("/product/{prodId}")
    public Product getProduct(@PathVariable int prodId) {
        return productService.getProductById(prodId);
    }

    @PostMapping("products")
    public Product addProduct(@RequestBody Product prod) {
        System.out.println(prod);
        return productService.addProduct(prod);
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product prod) {
        return productService.updateProduct(prod);
    }

    @DeleteMapping("product/{prodId}")
    public Product deleteProduct(@PathVariable int prodId) {
        System.out.println("delete product " + prodId);
        if (prodId <= 0){
            return  new Product();
        }
        return productService.deleteProduct(prodId);
    }
}
