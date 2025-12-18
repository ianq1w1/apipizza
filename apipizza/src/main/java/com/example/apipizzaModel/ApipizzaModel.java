package com.example.apipizzaModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name ="PizzaTable")
public class ApipizzaModel {
    private @Id
    @GeneratedValue Long id;
    private String sabor;

    ApipizzaModel() {}

    ApipizzaModel(String sabor){
        this.sabor = sabor;
    }


    public Long getId(){
        return this.id;
    }

    public String getSabor(){
        return this.sabor;
    }

    public void setId(Long settedId){
        this.id = settedId;
    }

    public void setSabor(String settedSabor){
        this.sabor = settedSabor;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof ApipizzaModel))
            return false;
        ApipizzaModel pizza = (ApipizzaModel) o;
        return Objects.equals(this.id, pizza.id) && Objects.equals(this.sabor, pizza.sabor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.sabor);
    }

    @Override
    public String toString() {
        return "ApipizzaModel{" + "id=" + this.id + ", name='" + this.sabor  + '}';
    }


}


