package com.ecommerce.jewellery.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AdminDto {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long adminId;

    @NotEmpty
    private String adminName;

    @Email
    private String email;

    @NotEmpty
    @Size(max = 8)
    private String adminPassword;
}
