package com.example.apipizzaService;

import org.springframework.beans.factory.annotation.Autowired;

//import com.example.DTOs.ApipizzaDTO;
import com.example.repositories.ApipizzaRepository;;

public class ApipizzaService {
    
    private ApipizzaRepository repository;

    public ApipizzaService(ApipizzaRepository repository){
        this.repository = repository;
    }
    
}
