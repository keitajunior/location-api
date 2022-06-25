package com.ekom.locationapp.specifications;

import com.ekom.locationapp.entities.UserLoc;
import org.springframework.data.jpa.domain.Specification;

public class UserLocSpecs {

    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";

    private static final GenericSpecification<UserLoc> userSpecifications = new GenericSpecification<>(UserLoc.class);

    private UserLocSpecs() throws IllegalAccessException {
        throw new IllegalAccessException("Utility class!");
    }

    public static Specification<UserLoc> withFirstname(String value) {
        return userSpecifications.withLike(FIRSTNAME, value);
    }

    public static Specification<UserLoc> withLastname(String value) {
        return userSpecifications.withLike(LASTNAME, value);
    }

}
