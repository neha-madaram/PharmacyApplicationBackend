package com.deployments.Entities;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Component
@Entity
@Table(name = "drugs")
@Data
@DynamicUpdate
public class Drugs {
    @Id
    @Column(name="drugId")
    private String drugId;

    @Column(name = "drugName")
    private String drugName;


    @Column(name = "pricePerUnit")
    private int priceperUnit;


    @Column(name = "dosage")
    private String dosage;

}