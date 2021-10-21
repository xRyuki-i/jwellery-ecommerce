package com.ecommerce.jewellery.controller;

import java.util.List;
import com.ecommerce.jewellery.model.Product;
import com.ecommerce.jewellery.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/getAllProducts")
    private List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/productById/{id}")
    private Product getById(@PathVariable Long id){
        System.out.println("->>>> "+id);
        return service.getById(id);
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<Product> setProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(
                service.save(product), HttpStatus.CREATED);
    }

    @PostMapping("/saveProducts")
    public ResponseEntity<List<Product>> setProducts(@RequestBody List<Product> products){
        return new ResponseEntity<List<Product>>(
                service.saveAll(products), HttpStatus.CREATED);
    }

    @PatchMapping("/updateProductQuantityById/{id}&{price}")
    public String updateProductPriceById(@PathVariable long id, @PathVariable Double price){
        return service.updateById(id, price);
    }

    @DeleteMapping("/deleteProductById/{id}")
    public String deleteProduct(@PathVariable Long id){
        return service.deleteById(id);
    }

    @DeleteMapping("/deleteProduct")
    public String deleteAll(){
        return service.deleteAll();
    }
}
