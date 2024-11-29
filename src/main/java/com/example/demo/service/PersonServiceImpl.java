package com.example.demo.service;

import com.example.demo.model.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;
    @Override
    public Person findPersonByUserId(Long userId) {
        return personRepository.findByUserId(userId);
    }
}
