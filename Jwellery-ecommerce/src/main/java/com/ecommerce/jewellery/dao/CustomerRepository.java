package com.ecommerce.jewellery.dao;

import com.ecommerce.jewellery.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByCustomerEmail(String email);

    List<Customer> findCustomerByCustomerEmailAndCustomerPassword(String email, String password);
}

