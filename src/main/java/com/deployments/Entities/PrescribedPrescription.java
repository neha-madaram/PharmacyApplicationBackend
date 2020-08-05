package com.deployments.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PrescribedPrescription")
public class PrescribedPrescription {

    @Id
    private String rx_id;

    @Column(name="patient_id")
    private int patient_id;

    @Column(name="prescriber_id")
    private int prescriber_id;


}
