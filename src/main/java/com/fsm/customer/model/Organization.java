package com.fsm.customer.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ORG")
public class Organization extends Person {

    private String orgName;
    private String orgContactPerson;
    private String orgEmail;

    @OneToOne(mappedBy = "organization",cascade = CascadeType.ALL)
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgContactPerson() {
        return orgContactPerson;
    }

    public void setOrgContactPerson(String orgContactPerson) {
        this.orgContactPerson = orgContactPerson;
    }

    public String getOrgEmail() {
        return orgEmail;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }
}
