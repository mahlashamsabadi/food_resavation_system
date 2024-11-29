package com.example.demo.model.dto;


import com.example.demo.model.entity.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonDto {
    private long id;
    private String fullName;
    private String nationalCode;
    private Long userId;
    private List<ContactDto> contacts;
    private List<AddressDto> addresses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ContactDto> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDto> contacts) {
        this.contacts = contacts;
    }

    public List<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDto> addresses) {
        this.addresses = addresses;
    }

    public static PersonDto map(Person person) {
        if (person == null){
            return null;
        }
        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setFullName(person.getFullName());
        dto.setNationalCode(person.getNationalCode());
        dto.setAddresses(person.getAddresses().stream().map(AddressDto::map).collect(Collectors.toList()));
        dto.setContacts(person.getContacts().stream().map(ContactDto::map).collect(Collectors.toList()));
        return dto;
    }
}
