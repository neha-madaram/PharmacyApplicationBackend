package com.deployments.Entities;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Subselect;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity
@Table(name="Patients")
@Data
@Component
@DynamicUpdate
@Subselect("select p.patientId, r.rxId from patient p, Rx r where p.patientId = r.rxID.patientId ")
public class Patients {
    @Id
    private String patientId;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="emailId")
    private String emailId;

    @Column(name="contactNumber")
    private String contactNumber;





}
