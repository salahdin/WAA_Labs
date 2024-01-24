package com.waa.lab5.model;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    @OneToOne
    private Person person;

    // Constructors, getters, setters
}
