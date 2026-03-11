package com.example.apipizza_Controller;

//import com.example.apipizzaModel.ApipizzaModel;
import com.example.DTOs.ApipizzaDTO;
import com.example.DTOs.RespostaApipizzaDTO;
import com.example.repositories.ApipizzaRepository;
import com.example.apipizzaService.ApipizzaService;

import org.springframework.beans.factory.annotation.Autowired;
//import com.example.repositories.ApipizzaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

 

//import com.example.repositories.ApipizzaRepository;

@RestController
@RequestMapping("/pizza")
public class ApipizzaController {
    
    private ApipizzaService service;
    public ApipizzaController(ApipizzaService service){
        this.service = service;
    }

    @PostMapping("/post")
    public RespostaApipizzaDTO createPizza(@RequestBody ApipizzaDTO dto) {
         return service.salvar(dto);       
    }
    
    /*
    @GetMapping("/pizza/{id}")
    ApipizzaModel one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("xiiii deu ruim"));
    } */
}

