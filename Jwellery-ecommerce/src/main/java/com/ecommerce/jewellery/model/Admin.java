package com.ecommerce.jewellery.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin", schema = "jewellery")
public class Admin {
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin",  fetch = FetchType.LAZY)
    @JsonManagedReference(value =  "admin-product")
    private List<Product> products;
}
