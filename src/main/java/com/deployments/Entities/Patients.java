package com.deployments.Entities;

import javax.persistence.*;

@Entity
@Table(name="Patients")
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patient_id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="emailId")
    private String email_id;




}
