package com.example.apipizza_Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pizza")
public class ApipizzaController {

    @GetMapping
    public String getPizza(){
        return "hmm pizza";
    }

}

