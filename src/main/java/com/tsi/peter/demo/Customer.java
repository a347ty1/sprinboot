package com.tsi.peter.demo;

import jakarta.persistence.*;

@Entity
@Table(name="customer")
public class Customer{

    @Id
    @Column(name="customer_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short customer_id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="email")
    private String email;

    @Column(name="address_id")
    private Integer address_id;

    public Integer getAddress_id() {
        return address_id;
    }

    public Short getCustomer_id() {
        return customer_id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public void setCustomer_id(Short customer_id) {
        this.customer_id = customer_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
