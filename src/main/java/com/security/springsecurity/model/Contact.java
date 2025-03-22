package com.security.springsecurity.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_birth")
    private LocalDate dataBirth;

    private String numberPhone;

    private String email;
}
