package com.example.demo.model.dto;

import com.example.demo.model.entity.Contact;

public class ContactDto {
    private long id;
    private String value;
    private String contactTypeName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getContactTypeName() {
        return contactTypeName;
    }

    public void setContactTypeName(String contactTypeName) {
        this.contactTypeName = contactTypeName;
    }

    public static ContactDto map(Contact contact) {
        if (contact == null){
            return null;
        }
        ContactDto dto = new ContactDto();
        dto.setId(contact.getId());
        dto.setContactTypeName(contact.getContactType().getName());
        dto.setValue(contact.getValue());
        return dto;
    }
}

