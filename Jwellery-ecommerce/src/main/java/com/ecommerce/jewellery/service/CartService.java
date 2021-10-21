package com.ecommerce.jewellery.service;

import com.ecommerce.jewellery.model.Cart;
import com.ecommerce.jewellery.model.Product;
import com.ecommerce.jewellery.dao.CartRepository;
import java.util.*;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;

import com.ecommerce.jewellery.dao.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductService productService;

    public Cart save(Cart cart){
        int quantity = 1;
        Cart newCart = new Cart();
        newCart.setQuantity(cart.getQuantity());
        newCart.setCustomer(cart.getCustomer());
        newCart.setOrder(cart.getOrder());
        newCart.getProducts().addAll(
                cart.getProducts()
                        .stream()
                        .map(p->{
                            Product pp = productService.getById(p.getProductId());
                            pp.getCarts().add(newCart);
                            return pp;
                        }).collect(Collectors.toList())
        );

        return cartRepository.save(newCart);
    }

    public String  updateCartProductById(long id, Product product){

        Cart existingCart = getById(id);
        Cart newCart = new Cart();
        Collection<Product> newProducts = new ArrayList<>();

        newCart.setQuantity(existingCart.getQuantity());
        newCart.setCustomer(existingCart.getCustomer());
        newCart.setOrder(existingCart.getOrder());
        newProducts.add(product);
        existingCart.getProducts().addAll(
                newProducts
                        .stream()
                        .map(p->{
                            Product pp = productService.getById(p.getProductId());
                            pp.getCarts().add(existingCart);
                            return pp;
                        }).collect(Collectors.toList()));

        cartRepository.save(existingCart);

        return "Cart ID: "+id+" Updated and added new product";
    }
    public Cart getById(long id){
        return cartRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public List<Cart> getAll(){
        return cartRepository.findAll();
    }

    public Cart updateCart(Long id, Cart updatedCart){
        Cart existingCart = cartRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        existingCart.setQuantity(updatedCart.getQuantity());

        return cartRepository.save(existingCart);
    }



    public String deleteById(long id){
        cartRepository.deleteById(id);

        return "ID: "+id+" deleted";
    }

    public String deleteAll(){
        cartRepository.deleteAll();

        return "All Admin deleted";
    }

}























