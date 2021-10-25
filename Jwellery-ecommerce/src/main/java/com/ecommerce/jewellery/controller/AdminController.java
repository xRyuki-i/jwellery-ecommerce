package com.ecommerce.jewellery.controller;

import java.util.List;
import com.ecommerce.jewellery.model.Admin;
import com.ecommerce.jewellery.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/admin")
    private List<Admin> getAll(){
        return service.getAllAdmin();
    }

    @PostMapping("/saveAdmin")
    public ResponseEntity<Admin> setAdmin(@RequestBody Admin admin){
        return new ResponseEntity<Admin>(
                service.saveAdmin(admin), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable Long id){
        return service.deleteAdminById(id);
    }

    @DeleteMapping("/deleteAdmin")
    public String deleteAll(){
        return service.deleteAllAdmin();
    }

    @GetMapping("/admin/login")
    public Object loginAdmin(@RequestParam("email") String email,@RequestParam("adminPassword") String adminPassword){
        return service.validate(email, adminPassword);
    }
}
