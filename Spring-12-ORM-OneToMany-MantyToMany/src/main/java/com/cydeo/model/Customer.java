package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String name;
    private String sureName;
    private String email;
    private String address;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY) // customer table da olmayacak, eager default fetch
    private List<Payment> paymentList;

    public Customer(String userName, String name, String sureName, String email, String address) {
        this.userName = userName;
        this.name = name;
        this.sureName = sureName;
        this.email = email;
        this.address = address;
    }
}
