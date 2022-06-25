package com.ekom.locationapp.entities;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;


@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_ACCOUNT", length = 8, discriminatorType = DiscriminatorType.STRING)
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "login", "phoneNumber" }) })
public class UserLoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    private Address address;
    private OffsetDateTime createdOn;
    private String createdBy;
    private OffsetDateTime lastModifyOn;
    private OffsetDateTime lastConnectionOn;

}
