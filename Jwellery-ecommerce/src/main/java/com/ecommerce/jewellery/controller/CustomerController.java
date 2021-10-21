package com.ecommerce.jewellery.controller;

import java.util.List;
import com.ecommerce.jewellery.model.Customer;
import com.ecommerce.jewellery.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/customer")
    private List<Customer> getAll(){
        return service.getAll();
    }

    @GetMapping("/ById/{id}")
    private Customer getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping("/saveCustomer")
    public ResponseEntity<Customer> setCustomer(@RequestBody Customer customer){
        return new ResponseEntity<Customer>(
                service.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return new ResponseEntity<Customer>(
                service.updateCustomer(id, customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCustomerById/{id}")
    public String deleteCustomer(@PathVariable Long id){
        return service.deleteById(id);
    }

    @DeleteMapping("/deleteCustomer")
    public String deleteAll(){
        return service.deleteAll();
    }
}
