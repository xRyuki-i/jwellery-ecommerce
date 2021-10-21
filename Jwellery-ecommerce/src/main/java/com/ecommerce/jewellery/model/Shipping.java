package com.ecommerce.jewellery.model;

import lombok.*;
import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shipping", schema = "jewellery")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shippingId;
    private String address;
    private Date deliveryDate;

    @OneToOne(mappedBy = "shipping", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "orders-shipping")
    private Orders orders;
}
