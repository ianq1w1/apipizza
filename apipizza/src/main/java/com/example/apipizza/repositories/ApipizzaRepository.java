package com.example.apipizza.repositories;

import com.example.apipizza.apipizzaModel.ApipizzaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApipizzaRepository extends JpaRepository<ApipizzaModel, Long> {
}