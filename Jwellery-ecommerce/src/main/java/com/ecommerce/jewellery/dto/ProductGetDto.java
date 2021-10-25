package com.ecommerce.jewellery.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
public class ProductGetDto {
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
}
