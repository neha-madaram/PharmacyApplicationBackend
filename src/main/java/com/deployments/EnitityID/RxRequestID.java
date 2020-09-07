package com.deployments.EnitityID;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class RxRequestID implements Serializable {

    @Column(name="prescriberId")
    String prescriberId;

    @Column(name="patientId")
    String patientId;

}
