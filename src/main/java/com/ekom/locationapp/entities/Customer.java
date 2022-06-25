package com.ekom.locationapp.entities;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("CUSTOMER")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Customer extends UserLoc {
    @OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Command> commands= new ArrayList<>();
}
