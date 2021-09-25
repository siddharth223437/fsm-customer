package com.fsm.customer.controller;

import com.fsm.customer.dto.PersonDTO;
import com.fsm.customer.service.PersonMap;
import com.fsm.customer.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create")
    public ResponseEntity<String> createPerson(@RequestBody PersonDTO personDTO){
        try{
            PersonMap personMap = new PersonMap();
            personMap.set("name.firstName",personDTO.getFirstName());
            personMap.set("name.lastName",personDTO.getLastName());
            personMap.set("email",personDTO.getEmail());
            if(personDTO.getAddressDTO() != null) {
                personMap.set("address.street1", personDTO.getAddressDTO().getStreet1());
                personMap.set("address.street2", personDTO.getAddressDTO().getStreet2());
                personMap.set("address.street3", personDTO.getAddressDTO().getStreet3());
                personMap.set("address.city", personDTO.getAddressDTO().getCity());
                personMap.set("address.state", personDTO.getAddressDTO().getState());
                personMap.set("address.zipcode", personDTO.getAddressDTO().getZipcode());
                personMap.set("address.phoneNumber", personDTO.getAddressDTO().getPhoneNumber());
            }

            if(personDTO.getCompanyDTO() != null) {
                personMap.set("company.name", personDTO.getCompanyDTO().getCompanyName());
            }
            personService.createPerson(personMap);
            return new ResponseEntity<String>("success",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
        }
    }
}
