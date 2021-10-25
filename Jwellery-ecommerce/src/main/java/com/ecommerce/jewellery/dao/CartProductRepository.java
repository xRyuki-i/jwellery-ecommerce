package com.ecommerce.jewellery.dao;

import com.ecommerce.jewellery.model.CartProduct;
import com.ecommerce.jewellery.model.CartProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
    CartProduct findByCartProductId(CartProductId cartProductId);

    void deleteByCartProductId(CartProductId cartProductId);
}
