package com.ecommerce.jewellery.dao;

import com.ecommerce.jewellery.model.Payment;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
