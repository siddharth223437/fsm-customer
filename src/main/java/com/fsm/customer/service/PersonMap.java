package com.fsm.customer.service;

public class PersonMap extends PropertyMap {

    protected void setupValidProperties(){
        super.setupValidProperties();
        setupProperty("name.firstName","First Name");
        setupProperty("name.lastName","Last Name");
        setupProperty("email","Email");
        setupProperty("address.street1","Street 1");
        setupProperty("address.street2","Street 2");
        setupProperty("address.street3","Street 3");
        setupProperty("address.city","city");
        setupProperty("address.state","state");
        setupProperty("address.zipcode","zipcode");
        setupProperty("address.phoneNumber","phone number");

        setupProperty("org.name","Organization Name");
        setupProperty("org.contactPerson","Organization Contact Name");
        setupProperty("org.email","email");
//        setupProperty("company.name","Company Name");
    }
}
