package com.ecommerce.jewellery.service;

import com.ecommerce.jewellery.dao.CartProductRepository;
import com.ecommerce.jewellery.model.Cart;
import com.ecommerce.jewellery.model.CartProduct;
import com.ecommerce.jewellery.model.CartProductId;
import com.ecommerce.jewellery.model.Product;
import com.ecommerce.jewellery.dao.CartRepository;
import java.util.*;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import com.ecommerce.jewellery.dao.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductService productService;

    @Autowired
    CartProductRepository cartProductRepository;

    public Cart saveCart(Cart cart){
        Cart newCart = new Cart();
        newCart.setOrder(cart.getOrder());
        newCart.setCustomer(cart.getCustomer());

        newCart.getCartProducts().addAll((cart.getCartProducts()
                .stream()
                .map(cp -> {
                    System.out.println(cp);
                    Product pp = productService.getById(cp.getProduct().getProductId());
                    CartProduct newCartProduct = new CartProduct();
                    newCartProduct.setProduct(pp);
                    newCartProduct.setCart(newCart);
                    newCartProduct.setQuantity(cp.getQuantity());

                    return newCartProduct;
                }).collect(Collectors.toList())
        ));
        return cartRepository.save(newCart);

    }

    public String  updateCartProductById(long id, CartProduct cartProduct){
        Cart existingCart = getById(id);
        Cart newCart = new Cart();
        Collection<CartProduct> newCartProducts = new ArrayList<>();
        System.out.println(cartProduct);
        newCart.setOrder(existingCart.getOrder());
        newCart.setCustomer(existingCart.getCustomer());
        newCartProducts.add(cartProduct);
        existingCart.getCartProducts().addAll((newCartProducts
                .stream()
                .map(cp -> {
                    System.out.println(cp);
                    Product pp = productService.getById(cp.getProduct().getProductId());
                    CartProduct newCartProduct = new CartProduct();
                    newCartProduct.setProduct(pp);
                    newCartProduct.setCart(existingCart);
                    newCartProduct.setQuantity(cp.getQuantity());

                    return newCartProduct;
                }).collect(Collectors.toList())
        ));
        cartRepository.save(existingCart);

        return "Cart ID: "+id+" Updated and added new product";
    }

    public Cart getById(long id){
        return cartRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
        public List<Cart> getAll(){
            return cartRepository.findAll();
        }

    public Collection<CartProduct> updateCartQuantityById(Long cartId,Long productId, int quantity){
        Cart existingCart = cartRepository.findById(cartId).orElseThrow(EntityNotFoundException::new);
        CartProduct existingCartProduct = cartProductRepository.findByCartProductId(new CartProductId(cartId, productId));
        existingCartProduct.setQuantity(quantity);

        existingCart.getCartProducts().stream().map(e->{
            if(e.getCartProductId() == existingCartProduct.getCartProductId()){
                e.setQuantity(quantity);
            }

            return existingCart;
        }).collect(Collectors.toList());

        existingCart.setCartProducts(existingCart.getCartProducts());
        cartRepository.save(existingCart);

        return existingCart.getCartProducts();
    }

    public String deleteCartById(long id){
        cartRepository.deleteById(id);
        return "Cart ID: "+id+" is deleted";
    }


    public String deleteAll(){
        cartRepository.deleteAll();

        return "All Admin deleted";
    }

    public String deleteCartProductById(Long cartId,Long productId){
        cartProductRepository.deleteByCartProductId(new CartProductId(cartId, productId));
        return "Cart deleted";
    }

}























