package com.ecommerce.jewellery.controller;

import java.io.IOException;
import java.util.List;

import com.ecommerce.jewellery.dto.ProductDto;
import com.ecommerce.jewellery.dto.ProductGetDto;
import com.ecommerce.jewellery.model.Product;
import com.ecommerce.jewellery.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
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
    public ResponseEntity<ProductGetDto> setProduct(@RequestParam("product")  String product, @RequestParam("file") MultipartFile file) throws IOException {
        ProductDto productPostDto = new ObjectMapper().readValue(product, ProductDto.class);
        return new ResponseEntity<ProductGetDto>(
                service.save(productPostDto, file), HttpStatus.CREATED);
    }

    @PutMapping("/updateProductById/{id}")
    public String updateProducts(@PathVariable("id") Long productId,@RequestParam("product") String product, @RequestParam("file") MultipartFile file) throws IOException {
        ProductDto productDto = new ObjectMapper().readValue(product, ProductDto.class);

        return service.updateProduct(productId, productDto, file);
    }

    @PatchMapping("/updateProductQuantityById/{id}&{quantity}")
    public String updateProductQuantityById(@PathVariable long id, @PathVariable int quantity){
        return service.updateById(id, quantity);
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
