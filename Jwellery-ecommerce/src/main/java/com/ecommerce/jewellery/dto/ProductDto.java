package com.ecommerce.jewellery.dto;

import com.ecommerce.jewellery.model.Admin;
import com.ecommerce.jewellery.model.Category;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
public class ProductDto {
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

    private Admin admin;

    private Category category;
}
