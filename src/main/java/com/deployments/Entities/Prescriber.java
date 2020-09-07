package com.deployments.Entities;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="Prescriber")
@Data
@Component
public class Prescriber {

    @Id
    private String prescriberId;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="contactNumber")
    private String contactNumber;
}
