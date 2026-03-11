package com.example.apipizzaService;

import org.springframework.stereotype.Service;

//import org.springframework.beans.factory.annotation.Autowired;

import com.example.DTOs.ApipizzaDTO;
import com.example.DTOs.RespostaApipizzaDTO;
import com.example.repositories.ApipizzaRepository;
import com.example.apipizzaModel.ApipizzaModel;


import jakarta.transaction.Transactional;;

@Service
public class ApipizzaService {
    
    private ApipizzaRepository repository;

    public ApipizzaService(ApipizzaRepository repository){
        this.repository = repository;
    }

    @Transactional
    public RespostaApipizzaDTO salvar(ApipizzaDTO dto){
        ApipizzaModel pizza = new ApipizzaModel();

        pizza.setSabor(dto.sabor());
        ApipizzaModel pizzaSalva = repository.save(pizza);
        return new RespostaApipizzaDTO(pizzaSalva.getId(), pizzaSalva.getSabor()); 
    }
    
}
