package com.ecommerce.jewellery.service;

import com.ecommerce.jewellery.dao.CustomerRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;

import com.ecommerce.jewellery.model.Customer;
import com.ecommerce.jewellery.util.CustomerValidator;
import com.ecommerce.jewellery.view.ResponseObject;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Object registration(Customer customer) {
        /*
         * validate the email
         */
        if (!CustomerValidator.validateEmail(customer.getCustomerEmail())) {
            return new ResponseObject(5, "This is invaild email!");
        }

        /*
         *validate the first name
         */
        if (!CustomerValidator.validateFirstname(customer.getCustomerName())) {
            return new ResponseObject(6, "Customer Name Is Not Valid!");
        }
        /*
         * validate last name
         */
        if (!CustomerValidator.validateAddress(customer.getCustomerAddress())) {

            return new ResponseObject(7, "Address Is Not Valid!");
        }

        /*
         * validate password
         */

        if (!CustomerValidator.validatePassword(customer.getCustomerPassword())) {
            return new ResponseObject(8, "Invallid password!");
        }

        if (!CustomerValidator.validateMobile(customer.getCustomerPhone())) {
            return new ResponseObject(10, "Enter Valid Mobile Number!");
        }

        Customer user = customerRepository.findCustomerByCustomerEmail(customer.getCustomerEmail());

        if (user != null) {
            return new ResponseObject(9, "This user already  exists!");
        }

        user = new Customer();
        user.setCustomerName(customer.getCustomerName());
        user.setCustomerEmail(customer.getCustomerEmail());
        user.setCustomerAddress(customer.getCustomerAddress());
        user.setCustomerPhone(customer.getCustomerPhone());
        user.setCustomerPassword(customer.getCustomerPassword());
        customerRepository.save(user);

        return new ResponseObject(1, "you have sucessfully registered!");
    }

    public Object validate(String email, String password){
        List<Customer> customers = customerRepository.findCustomerByCustomerEmailAndCustomerPassword(email, password);
        if(customers.size() != 0){
            return customers;
        }
        else{
            return new ResponseObject(0, "Invalid email or password!");
        }

    }

    public Customer getCustomerById(long id){
        return customerRepository.findById(id).orElseThrow(EntityNotFoundException::new) ;
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
