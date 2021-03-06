package com.ecommerce.jewellery.model;

import lombok.*;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Table(name = "product", schema = "jewellery")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @NotEmpty
    private String name;
    @NotEmpty
    private String detail;
//    @NotEmpty
//    private String type;
    @NotEmpty
    private double productPrice;

    @NotEmpty
    private int productQuantity;

    @NotEmpty
    private String image;
//    @NotEmpty
//    private String productCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adminId")
    @JsonBackReference(value = "admin-product")
    private Admin admin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    @JsonBackReference(value = "product-category")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    @JsonManagedReference(value =  "product-cartProduct")
    @JsonIgnore
    private  Collection<CartProduct> cartProducts = new ArrayList<>();

}

