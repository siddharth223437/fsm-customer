package com.fsm.customer.service;


import com.fsm.customer.dao.PersonDao;
import com.fsm.customer.model.Address;
import com.fsm.customer.model.Company;
import com.fsm.customer.model.PersonBio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    /*
    * what we need
    *
    * */

    private PersonMap personMap;

    @Autowired
    private PersonDao personDao;

    public void createPerson(PersonMap personMap) throws IllegalAccessException {
        this.personMap = personMap;
        buildPersonBio();
    }

    private void buildPersonBio() throws IllegalAccessException{
        PersonBio bio = new PersonBio();
        bio.setFirstName(this.personMap.get("name.firstName"));
        bio.setLastName(this.personMap.get("name.lastName"));
        bio.setEmail(this.personMap.get("email"));
        Address address = null;
        if(this.personMap.get("address.street1") != null) {
             address = buildAddress();
        }

        if(this.personMap.get("company.name") != null) {
            Company company = new Company();
            company.setCompanyName(this.personMap.get("company.name"));
            personDao.save(company);
            address.setCompany(company);
            bio.setCompany(company);
        }

        if(address != null) {
            address.setPerson(bio);
            bio.addAddress(address);
        }

        personDao.save(bio);



    }

    private Address buildAddress() throws IllegalAccessException{
        Address address = new Address();
        address.setStreet1(this.personMap.get("address.street1"));
        address.setStreet2(this.personMap.get("address.street2"));
        address.setStreet3(this.personMap.get("address.street3"));
        address.setCity(this.personMap.get("address.city"));
        address.setState(this.personMap.get("address.state"));
        address.setPhoneNumber(this.personMap.get("address.phoneNumber"));
        address.setZipcode(this.personMap.get("address.zipcode"));
        return address;
    }
}
