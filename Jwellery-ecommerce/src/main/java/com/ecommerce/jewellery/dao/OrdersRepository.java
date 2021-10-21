package com.ecommerce.jewellery.dao;

import com.ecommerce.jewellery.model.Orders;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
