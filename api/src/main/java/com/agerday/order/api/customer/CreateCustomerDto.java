package com.agerday.order.api.customer;

public class CreateCustomerDto {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;


    public CreateCustomerDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateCustomerDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CreateCustomerDto withEmail(String email) {
        this.email = email;
        return this;
    }

    public CreateCustomerDto withAddress(String address) {
        this.address = address;
        return this;
    }

    public CreateCustomerDto withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
