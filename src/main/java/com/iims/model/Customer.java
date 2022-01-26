package com.iims.model;

public class Customer {
    int id;
    String name, address;
    long contact;

    public Customer() {}

    public Customer(String name, String address, long contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public Customer(int id, String name, String address, long contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }
}
