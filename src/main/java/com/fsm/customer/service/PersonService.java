package com.fsm.customer.service;


import com.fsm.customer.dao.OrgDao;
import com.fsm.customer.dao.PersonDao;
import com.fsm.customer.model.Address;
import com.fsm.customer.model.Employee;
import com.fsm.customer.model.Organization;
import com.fsm.customer.model.PersonBio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    /*
    * what we need
    *
    * */

    public PersonService(){

    }

    private PersonMap personMap;
    PersonBio bio = null;
    Address address = null;
    Organization organization = null;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private OrgDao orgDao;

    public void createPerson(PersonMap personMap) throws IllegalAccessException {
        bio = null;
        address = null;
        organization = null;
        this.personMap = personMap;
        buildPersonBio();
        if(bio != null && organization != null){
            return;
        }
        if(address != null && bio != null) {
            address.setPerson(bio);
            bio.addAddress(address);
            personDao.save(bio);
        }
        if(address != null && organization != null){
            address.setPerson(organization);
            organization.addAddress(address);
            personDao.save(organization);
        }
    }

    private void buildPersonBio() throws IllegalAccessException{

        if(this.personMap.get("name.firstName") != null){
            bio = new PersonBio();
            bio.setFirstName(this.personMap.get("name.firstName"));
            bio.setLastName(this.personMap.get("name.lastName"));
            bio.setEmail(this.personMap.get("email"));
        }

        if(this.personMap.get("address.street1") != null) {
             address = buildAddress();
        }

        if(this.personMap.get("org.name") != null) {
             organization = new Organization();
            organization.setOrgName(this.personMap.get("org.name"));
            organization.setOrgContactPerson(this.personMap.get("org.contactPerson"));
            organization.setOrgEmail(this.personMap.get("org.email"));


//            Company company = new Company();
//            company.setCompanyName(this.personMap.get("company.name"));
//            personDao.save(company);
//            address.setCompany(company);
//            bio.setCompany(company);
        }








    }

    public void createPerson(PersonMap personMap, String orgName) throws IllegalAccessException {
        bio = null;
        address = null;
        organization = null;
        this.personMap = personMap;
        buildPersonBio();
        this.organization = orgDao.findByOrgName(orgName);
        Employee employee = new Employee();
        employee.setOrganization(organization);
        employee.setPersonBio(bio);
        this.orgDao.save(bio);
        orgDao.save(employee);

        this.address.setEmployee(employee);
        address.setPerson(bio);
//        this.bio.setCompany(company);
//        this.bio.addAddress(address);
        this.orgDao.save(address);


//        this.orgDao.save(organization);
//        this.orgDao.save(address);
//
//        orgDao.merge(company);





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
