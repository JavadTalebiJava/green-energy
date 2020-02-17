package com.greenenergy.repository;

import com.greenenergy.model.InitialProcess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository is for all operations for all {@link InitialProcess}.
 *
 * @author javad talebi
 */
public interface InitialProcessRepository extends JpaRepository<InitialProcess, Long> {

    Optional<InitialProcess> findTopByOrderById();
}
