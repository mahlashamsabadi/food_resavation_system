package com.example.demo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSON_ADDRESS", schema = "FR")
public class PersonAddress {
    private long id;
    private long addressId;
    private long personId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_address_seq")
    @SequenceGenerator(name = "person_address_seq", sequenceName = "person_address_seq", allocationSize = 1)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ADDRESS_ID")
    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "PERSON_ID")
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

}
