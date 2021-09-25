package com.fsm.customer.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEES")
@AttributeOverride(name = "id", column = @Column(name = "EMPLOYEE_ID"))
public class Employee extends Persistent {

    @OneToOne
    @JoinColumn(name = "ORG_ID")
    private Organization organization;

    @OneToOne
    @JoinColumn(name = "INDIVIDUAL_ID")
    private PersonBio personBio;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public PersonBio getPersonBio() {
        return personBio;
    }

    public void setPersonBio(PersonBio personBio) {
        this.personBio = personBio;
    }
}
