package com.ecommerce.jewellery.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category", schema = "jewellery")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @NotEmpty
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category",  fetch = FetchType.LAZY)
    @JsonManagedReference(value =  "product-category")
    private List<Product> products;

}
