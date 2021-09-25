package com.fsm.customer.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
@AttributeOverride(name = "id", column = @Column(name = "COMPANY_ID"))
public class Company extends Persistent {

    private String companyName;
    @OneToMany(mappedBy = "company")
    private List<PersonBio> personBio = new ArrayList<>();
    @OneToMany(mappedBy = "company")
    private List<Address> addresses = new ArrayList<>();

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<PersonBio> getPersonBio() {
        return personBio;
    }

    public void setPersonBio(List<PersonBio> personBio) {
        this.personBio = personBio;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
