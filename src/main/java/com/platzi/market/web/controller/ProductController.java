package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get-all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/get/{productId}")
    public Optional<Product> getProduct(@PathVariable int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/get-by-category")
    public Optional<List<Product>> getByCategory(int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{productId}")
    public boolean delete(@PathVariable int productId){
        return productService.delete(productId);
    }

}
