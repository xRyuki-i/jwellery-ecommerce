package com.ecommerce.jewellery.service;

import com.ecommerce.jewellery.dao.CustomerRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;

import com.ecommerce.jewellery.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer getById(long id){
        return customerRepository.findById(id).orElseThrow(EntityNotFoundException::new) ;
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer){
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
        existingCustomer.setCustomerAddress(updatedCustomer.getCustomerAddress());
        existingCustomer.setCustomerPhone(updatedCustomer.getCustomerPhone());
        existingCustomer.setCustomerEmail(updatedCustomer.getCustomerEmail());
        existingCustomer.setCustomerPassword(updatedCustomer.getCustomerPassword());

        return customerRepository.save(existingCustomer);
    }

    public String deleteById(long id){
        customerRepository.deleteById(id);

        return "ID: "+id+" deleted";
    }

    public String deleteAll(){
        customerRepository.deleteAll();

        return "All Admin deleted";
    }
}
