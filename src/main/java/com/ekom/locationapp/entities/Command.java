package com.ekom.locationapp.entities;

import com.ekom.locationapp.converters.CommandStatusConverter;
import com.ekom.locationapp.enums.CommandStatus;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "DELIVERY_ADDRESS_ID", referencedColumnName = "ID")
    private Address deliveryAddress;
    private OffsetDateTime createdOn;
    private OffsetDateTime endDate;
    private OffsetDateTime lastModifyOn;
    @Convert(converter = CommandStatusConverter.class)
    private CommandStatus commandStatus;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ORDERED_PRODUCT_ID", referencedColumnName = "ID")
    private Product product;
}
