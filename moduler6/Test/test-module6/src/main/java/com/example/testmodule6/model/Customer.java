package com.example.testmodule6.model;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    private int id;
    private String name;
    private String dayOfBirth;
    private String address;
    @ManyToOne
    private CustomerType customerType;

    public Customer(int id, String name, String dayOfBirth, String address) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
    }

    public Customer() {
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

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
