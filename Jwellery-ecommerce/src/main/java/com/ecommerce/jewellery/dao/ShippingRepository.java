package com.ecommerce.jewellery.dao;

import com.ecommerce.jewellery.model.Shipping;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}
