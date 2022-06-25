package com.ekom.locationapp.entities;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("SUPPLIER")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "enterpriseName"}) })
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Supplier extends UserLoc {
    private String enterpriseName;
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products= new ArrayList<>();
}
