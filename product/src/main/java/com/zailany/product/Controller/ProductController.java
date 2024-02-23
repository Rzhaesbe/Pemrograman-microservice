/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zailany.product.Controller;

import com.zailany.product.Service.ProductService;
import com.zailany.product.Entity.Product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @Rzhaesbe
 */
@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }
    
    @PostMapping
    public void insert(@RequestBody Product product){
        productService.insert(product);
    }
    
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Product product) {
        productService.update(id, product);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}