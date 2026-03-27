package com.example.apipizza.apipizzaService;

import org.springframework.stereotype.Service;

//import org.springframework.beans.factory.annotation.Autowired;

import com.example.apipizza.DTOs.ApipizzaDTO;
import com.example.apipizza.DTOs.RespostaApipizzaDTO;
import com.example.apipizza.repositories.ApipizzaRepository;
import com.example.apipizza.repositories.UserRepository;
import com.example.apipizza.apipizzaModel.userEntity;
import com.example.apipizza.apipizzaModel.ApipizzaModel;


import jakarta.transaction.Transactional;;

@Service
public class ApipizzaService {
    
    private final ApipizzaRepository repository;
    private final UserRepository urepository;

    public ApipizzaService (ApipizzaRepository repository, UserRepository urepository){
        this.repository = repository;
        this.urepository = urepository;
    }


    @Transactional
    public RespostaApipizzaDTO salvar(ApipizzaDTO dto){
        userEntity user = urepository.findById(dto.userID())
            .orElseThrow(()-> new RuntimeException("esse cara nao existe"));

        ApipizzaModel pizza = new ApipizzaModel();

        pizza.setSabor(dto.sabor());
        pizza.setUser(user);

        ApipizzaModel pizzaSalva = repository.save(pizza);
        return new RespostaApipizzaDTO(pizzaSalva.getId(), pizzaSalva.getSabor()); 
    }


    public RespostaApipizzaDTO listOne(Long id){

        ApipizzaModel pizzaListada = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("pizza nao encontrada"));
        return new RespostaApipizzaDTO(pizzaListada.getId(), pizzaListada.getSabor());

    }
    
}
