package com.ecommerce.jewellery.service;

import com.ecommerce.jewellery.mapper.LoginMapper;
import com.ecommerce.jewellery.model.Admin;
import com.ecommerce.jewellery.dao.AdminRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;

import com.ecommerce.jewellery.view.ResponseObject;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private LoginMapper loginMapper;

    public Admin saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }

    public Admin updateAdmin(Long id, Admin updatedAdmin){
        Admin existingAdmin = adminRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        existingAdmin.setAdminName(updatedAdmin.getAdminName());
        existingAdmin.setAdminPassword(updatedAdmin.getAdminPassword());
        existingAdmin.setEmail(updatedAdmin.getEmail());

        return adminRepository.save(existingAdmin);
    }

    public Object validate(String email, String password){
        List<Admin> admins = adminRepository.getAdminByAdminEmailAndAdminPassword(email, password);
        if(admins.size() != 0){
            return loginMapper.INSTANCE.modelsToDto(admins);
        }
        else{
            return new ResponseObject(0, "Invalid email or password!");
        }

    }

    public String deleteAdminById(long id){
        adminRepository.deleteById(id);

        return "ID: "+id+" deleted";
    }

    public String deleteAllAdmin(){
        adminRepository.deleteAll();

        return "All Admin deleted";
    }

}
