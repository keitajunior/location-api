package com.ekom.locationapp.repositories;

import com.ekom.locationapp.entities.UserLoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserLocRepository extends JpaRepository<UserLoc, Long>, JpaSpecificationExecutor<UserLoc> {
}
