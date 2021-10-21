package com.ecommerce.jewellery.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import java.util.*;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart", schema = "jewellery")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    private int quantity;

    @ManyToMany(mappedBy = "carts" , cascade = CascadeType.ALL)
    private Collection<Product> products = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
    @JsonBackReference(value = "customer-cart")
    private Customer customer;

    @OneToOne(mappedBy = "cart", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "orders-cart")
    private Orders order;
}

