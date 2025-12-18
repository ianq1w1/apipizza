package com.example.repositories;

import com.example.apipizzaModel.ApipizzaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApipizzaRepository extends JpaRepository<ApipizzaModel, Long> {
}