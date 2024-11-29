package com.example.demo.model.dto;

import com.example.demo.model.entity.Address;

public class AddressDto {
    private long id;
    private String value;
    private String city;
    private String postalCode;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public static AddressDto map(Address address) {
        if (address == null){
            return null;
        }
        AddressDto addressDto = new AddressDto();
        addressDto.setId(addressDto.getId());
        addressDto.setCity(addressDto.getCity());
        addressDto.setValue(address.getValue());
        addressDto.setPostalCode(address.getPostalCode());
        return addressDto;
    }
}
