package com.example.demo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSON_CONTACT", schema = "FR")
public class PersonContact {
    private long id;
    private long personId;
    private long contactId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_contact_seq")
    @SequenceGenerator(name = "person_contact_seq", sequenceName = "person_contact_seq", allocationSize = 1)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PERSON_ID")
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "CONTACT_ID")
    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

}
