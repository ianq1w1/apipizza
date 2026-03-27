package com.example.apipizza.apipizzaService;

import org.springframework.stereotype.Service;

//import org.springframework.beans.factory.annotation.Autowired;

import com.example.apipizza.DTOs.ApipizzaDTO;
import com.example.apipizza.DTOs.RespostaApipizzaDTO;
import com.example.apipizza.repositories.ApipizzaRepository;
import com.example.apipizza.apipizzaModel.ApipizzaModel;


import jakarta.transaction.Transactional;;

@Service
public class ApipizzaService {
    
    private final ApipizzaRepository repository;

    public ApipizzaService (ApipizzaRepository repository){
        this.repository = repository;
    }


    @Transactional
    public RespostaApipizzaDTO salvar(ApipizzaDTO dto){
        ApipizzaModel pizza = new ApipizzaModel();

        pizza.setSabor(dto.sabor());
        ApipizzaModel pizzaSalva = repository.save(pizza);
        return new RespostaApipizzaDTO(pizzaSalva.getId(), pizzaSalva.getSabor()); 
    }


    public RespostaApipizzaDTO listOne(Long id){

        ApipizzaModel pizzaListada = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("pizza nao encontrada"));
        return new RespostaApipizzaDTO(pizzaListada.getId(), pizzaListada.getSabor());

    }
    
}
