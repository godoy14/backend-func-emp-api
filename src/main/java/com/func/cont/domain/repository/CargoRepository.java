package com.func.cont.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.func.cont.domain.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
