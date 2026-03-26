package com.example.apipizza.repositories;

import com.example.apipizza.apipizzaModel.userEntity;

//import com.example.apipizza.DTOs.;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<userEntity, Long> {
    
}
