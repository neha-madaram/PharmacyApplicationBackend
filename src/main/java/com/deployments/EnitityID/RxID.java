package com.deployments.EnitityID;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
@Data
public class RxID implements Serializable {


    @Column(name="rxId")
    private String rxId;


    @Column(name="patientId")
    private String patientId;
}
