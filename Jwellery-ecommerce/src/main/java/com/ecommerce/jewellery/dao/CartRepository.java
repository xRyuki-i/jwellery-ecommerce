package com.ecommerce.jewellery.dao;

import com.ecommerce.jewellery.model.Cart;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}