package com.ecommerce.jewellery.controller;

import java.util.List;
import com.ecommerce.jewellery.model.Shipping;
import com.ecommerce.jewellery.service.ShippingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ShippingController {
    @Autowired
    private ShippingService service;

    @GetMapping("/shipping")
    private List<Shipping> getAll(){
        return service.getAll();
    }

    @GetMapping("/shippingById/{id}")
    private Shipping getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping("/saveShipping")
    public ResponseEntity<Shipping> setShipping(@RequestBody Shipping shipping){
        return new ResponseEntity<Shipping>(
                service.save(shipping), HttpStatus.CREATED);
    }

    @PutMapping("/updateShipping/{id}")
    public ResponseEntity<Shipping> updateShipping(@PathVariable Long id, @RequestBody Shipping shipping){
        return new ResponseEntity<Shipping>(
                service.updateShipping(id, shipping), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteShippingById/{id}")
    public String deleteShipping(@PathVariable Long id){
        return service.deleteById(id);
    }

    @DeleteMapping("/deleteShipping")
    public String deleteAll(){
        return service.deleteAll();
    }
}
