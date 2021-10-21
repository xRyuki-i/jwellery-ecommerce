package com.ecommerce.jewellery.dao;

import com.ecommerce.jewellery.model.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
