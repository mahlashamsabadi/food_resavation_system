package com.example.demo.service;

import com.example.demo.model.entity.Person;

public interface PersonService {

    Person findPersonByUserId(Long userId);
}
