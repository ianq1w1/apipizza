package com.example.apipizza.apipizza_Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.apipizza.DTOs.UserRequestDTO;
import com.example.apipizza.DTOs.UserResponseDTO;

import com.example.apipizza.apipizzaService.UserService;


@RestController
@RequestMapping("/usuario")
public class UserController {



    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    
    @PostMapping
    public UserResponseDTO criarUser(@RequestBody UserRequestDTO dto) {
        return service.criar(dto);
    }
    
}
