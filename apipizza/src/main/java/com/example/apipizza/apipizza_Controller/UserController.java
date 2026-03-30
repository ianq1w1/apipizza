package com.example.apipizza.apipizza_Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.apipizza.DTOs.UserRequestDTO;
import com.example.apipizza.DTOs.UserResponseDTO;
import com.example.apipizza.DTOs.UserLoginDTO;
import com.example.apipizza.apipizzaModel.userEntity;
import com.example.apipizza.apipizzaService.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/usuario")

public class UserController {

    private final UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    //create

    @PostMapping("/cadastro")
    public ResponseEntity <UserResponseDTO> criarUser(@RequestBody UserRequestDTO dto) {
        UserResponseDTO response = service.criar(dto);
        return ResponseEntity.status(201).body(response);
    }

    //login!!
    @PostMapping("/login")
    public ResponseEntity <UserResponseDTO> logarUser(@RequestBody UserLoginDTO dto) {
        //return();
    }
    
    
}
