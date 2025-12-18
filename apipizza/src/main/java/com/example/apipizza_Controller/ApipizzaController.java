package com.example.apipizza_Controller;

import com.example.apipizzaModel.ApipizzaModel;
import com.example.repositories.ApipizzaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.repositories.ApipizzaRepository;

@RestController
@RequestMapping("/pizza")
public class ApipizzaController {

    private final ApipizzaRepository repository;

    public ApipizzaController(ApipizzaRepository repository){
        this.repository = repository;
    }


    @GetMapping("/pizza/{id}")
    ApipizzaModel one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("xiiii deu ruim"));
    }
}

