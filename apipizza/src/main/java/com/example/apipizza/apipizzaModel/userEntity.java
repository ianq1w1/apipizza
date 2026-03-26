package com.example.apipizza.apipizzaModel;


import jakarta.persistence.CascadeType;
import java.util.List;
import java.util.ArrayList;
import com.example.apipizza.apipizzaModel.ApipizzaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class userEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long Id;
    private String email;
    private String nome;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApipizzaModel> pizzas = new ArrayList<>();
}
