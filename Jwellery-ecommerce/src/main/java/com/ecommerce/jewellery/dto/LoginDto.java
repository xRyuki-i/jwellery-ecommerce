package com.ecommerce.jewellery.dto;

import lombok.Data;

@Data
public class LoginDto {
    private long adminId;
    private String email;
    private String adminPassword;
}
