package com.ecommerce.jewellery.model;

import lombok.*;
import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment", schema = "jewellery")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;
    private String paymentType;
    private String paymentStatus;
    private Date paymentDate;

    @OneToOne(mappedBy = "payment", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "orders-payment")
    private Orders orders;
}
