package com.ekom.locationapp.repositories;

import com.ekom.locationapp.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommandRepository extends JpaRepository<Command, Long> , JpaSpecificationExecutor<Command> {
}
