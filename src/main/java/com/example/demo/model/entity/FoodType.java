package com.example.demo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FOOD_TYPE", schema = "FR")
public class FoodType {
    private long id;
    private String name;
    private String code;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_type_seq")
    @SequenceGenerator(name = "food_type_seq", sequenceName = "food_type_seq", allocationSize = 1)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
