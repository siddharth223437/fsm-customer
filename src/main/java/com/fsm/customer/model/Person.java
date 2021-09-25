package com.fsm.customer.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PERSON")
@AttributeOverride(name = "id", column = @Column(name = "PERSON_ID"))
@DiscriminatorColumn(name = "PERSON_TYPE")
public abstract class Person extends Persistent {

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Address> addresses = new HashSet<>();

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address addresses) {
        this.addresses.add(addresses);
    }
}
