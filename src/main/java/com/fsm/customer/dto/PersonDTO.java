package com.fsm.customer.dto;

import java.io.Serializable;

public class PersonDTO implements Serializable {

    private IndividualDTO individualDTO;
    private AddressDTO addressDTO;
    private OrganizationDTO organizationDTO;

    public IndividualDTO getIndividualDTO() {
        return individualDTO;
    }

    public void setIndividualDTO(IndividualDTO individualDTO) {
        this.individualDTO = individualDTO;
    }

    public OrganizationDTO getOrganizationDTO() {
        return organizationDTO;
    }

    public void setOrganizationDTO(OrganizationDTO organizationDTO) {
        this.organizationDTO = organizationDTO;
    }



    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public static class IndividualDTO {
        private String firstName;
        private String lastName;
        private String email;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static class AddressDTO implements Serializable {
        private String street1;
        private String street2;
        private String street3;
        private String city;
        private String state;
        private String zipcode;
        private String phoneNumber;

        public String getStreet1() {
            return street1;
        }

        public void setStreet1(String street1) {
            this.street1 = street1;
        }

        public String getStreet2() {
            return street2;
        }

        public void setStreet2(String street2) {
            this.street2 = street2;
        }

        public String getStreet3() {
            return street3;
        }

        public void setStreet3(String street3) {
            this.street3 = street3;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

    public static class OrganizationDTO implements Serializable {
        private String organizationName;
        private String organizationContactPerson;
        private String organizationEmail;

        public String getOrganizationName() {
            return organizationName;
        }

        public void setOrganizationName(String organizationName) {
            this.organizationName = organizationName;
        }

        public String getOrganizationContactPerson() {
            return organizationContactPerson;
        }

        public void setOrganizationContactPerson(String organizationContactPerson) {
            this.organizationContactPerson = organizationContactPerson;
        }

        public String getOrganizationEmail() {
            return organizationEmail;
        }

        public void setOrganizationEmail(String organizationEmail) {
            this.organizationEmail = organizationEmail;
        }
    }
}
