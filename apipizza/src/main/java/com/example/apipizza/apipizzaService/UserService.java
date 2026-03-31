package com.example.apipizza.apipizzaService;

import org.apache.catalina.User;
import org.hibernate.id.uuid.UuidVersion7Strategy;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.function.EntityResponse;
import jakarta.transaction.Transactional;


import com.example.apipizza.DTOs.UserResponseDTO;
import com.example.apipizza.DTOs.UserResponseLoginDTO;
import com.example.apipizza.DTOs.UserRequestDTO;
import com.example.apipizza.DTOs.UserLoginDTO;
import com.example.apipizza.DTOs.UserResponseDTO;
import com.example.apipizza.repositories.UserRepository;
import com.example.apipizza.apipizzaModel.userEntity;
import com.example.apipizza.apipizzaService.TokenService;


@Service
public class UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public UserService (UserRepository repository, BCryptPasswordEncoder passwordEncoder, TokenService tokenService){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }
    
    //criar
    @Transactional
    public UserResponseDTO criar(UserRequestDTO dto){
        userEntity user = new userEntity();

        user.setEmail(dto.email());
        user.setNome(dto.nome());

        user.setPassword(passwordEncoder.encode(dto.password())); // BCrypt aqui
  
        userEntity userSalvo = repository.save(user);

        return new UserResponseDTO(userSalvo.getEmail(), userSalvo.getNome());   
    }

    public UserResponseLoginDTO login(UserLoginDTO dto){
        userEntity user = repository.findByEmail(dto.email())
            .orElseThrow(() -> new RuntimeException("nao achamo esse email nao ein"));
        
        if(!passwordEncoder.matches(dto.password(), user.getPassword())){
            throw new RuntimeException("nao bateu a senha");
        }

        String token = tokenService.gerarToken(user);

        return new UserResponseLoginDTO(token, user.getEmail(), user.getNome());
    }
    
}