package com.fsm.customer.controller;

import com.fsm.customer.dto.PersonDTO;
import com.fsm.customer.service.PersonMap;
import com.fsm.customer.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create/{orgName}")
    public ResponseEntity<String> createPerson(@RequestBody PersonDTO personDTO, @PathVariable(value = "orgName", required = false) String orgName){
        try{
            PersonMap personMap = new PersonMap();
            if(personDTO.getIndividualDTO() != null){
                personMap.set("name.firstName",personDTO.getIndividualDTO().getFirstName());
                personMap.set("name.lastName",personDTO.getIndividualDTO().getLastName());
                personMap.set("email",personDTO.getIndividualDTO().getEmail());
            }

            if(personDTO.getAddressDTO() != null) {
                personMap.set("address.street1", personDTO.getAddressDTO().getStreet1());
                personMap.set("address.street2", personDTO.getAddressDTO().getStreet2());
                personMap.set("address.street3", personDTO.getAddressDTO().getStreet3());
                personMap.set("address.city", personDTO.getAddressDTO().getCity());
                personMap.set("address.state", personDTO.getAddressDTO().getState());
                personMap.set("address.zipcode", personDTO.getAddressDTO().getZipcode());
                personMap.set("address.phoneNumber", personDTO.getAddressDTO().getPhoneNumber());
            }

            if(personDTO.getOrganizationDTO() != null) {
                personMap.set("org.name", personDTO.getOrganizationDTO().getOrganizationName());
                personMap.set("org.contactPerson", personDTO.getOrganizationDTO().getOrganizationContactPerson());
                personMap.set("org.email", personDTO.getOrganizationDTO().getOrganizationEmail());
            }
            if(orgName != null){
                personService.createPerson(personMap, orgName);
            }else {
                personService.createPerson(personMap);
            }
            return new ResponseEntity<String>("success",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/create")
    public ResponseEntity<String> createPerson1(@RequestBody PersonDTO personDTO){
        try{
            PersonMap personMap = new PersonMap();
            if(personDTO.getIndividualDTO() != null){
                personMap.set("name.firstName",personDTO.getIndividualDTO().getFirstName());
                personMap.set("name.lastName",personDTO.getIndividualDTO().getLastName());
                personMap.set("email",personDTO.getIndividualDTO().getEmail());
            }

            if(personDTO.getAddressDTO() != null) {
                personMap.set("address.street1", personDTO.getAddressDTO().getStreet1());
                personMap.set("address.street2", personDTO.getAddressDTO().getStreet2());
                personMap.set("address.street3", personDTO.getAddressDTO().getStreet3());
                personMap.set("address.city", personDTO.getAddressDTO().getCity());
                personMap.set("address.state", personDTO.getAddressDTO().getState());
                personMap.set("address.zipcode", personDTO.getAddressDTO().getZipcode());
                personMap.set("address.phoneNumber", personDTO.getAddressDTO().getPhoneNumber());
            }

            if(personDTO.getOrganizationDTO() != null) {
                personMap.set("org.name", personDTO.getOrganizationDTO().getOrganizationName());
                personMap.set("org.contactPerson", personDTO.getOrganizationDTO().getOrganizationContactPerson());
                personMap.set("org.email", personDTO.getOrganizationDTO().getOrganizationEmail());
            }
                personService.createPerson(personMap);

            return new ResponseEntity<String>("success",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
        }
    }
}
