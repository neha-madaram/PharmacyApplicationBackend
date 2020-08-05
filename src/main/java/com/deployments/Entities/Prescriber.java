package com.deployments.Entities;

import javax.persistence.*;

@Entity
@Table(name="Prescriber")
public class Prescriber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int prescriber_id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="email")
    private String email;
}
