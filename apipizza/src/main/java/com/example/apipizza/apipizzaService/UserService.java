package com.example.apipizza.apipizzaService;

import org.apache.catalina.User;
import org.hibernate.id.uuid.UuidVersion7Strategy;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;
import jakarta.transaction.Transactional;


import com.example.apipizza.DTOs.UserResponseDTO;
import com.example.apipizza.DTOs.UserRequestDTO;
import com.example.apipizza.repositories.UserRepository;
import com.example.apipizza.apipizzaModel.userEntity;


@Service
public class UserService {

    private final UserRepository repository;

    public UserService (UserRepository repository){
        this.repository = repository;
    }
    
    @Transactional
    public UserResponseDTO criar(UserRequestDTO dto){
        userEntity user = new userEntity();

        user.setEmail(dto.email());
        user.setNome(dto.nome());

        //depois aplica o bcrypt com spring security!!!
        user.setPassword(dto.password());
        userEntity userSalvo = repository.save(user);

        return new UserResponseDTO(userSalvo.getEmail(), userSalvo.getNome());   
    }

    
}