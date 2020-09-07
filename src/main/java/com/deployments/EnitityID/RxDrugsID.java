package com.deployments.EnitityID;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;


@Data
@Embeddable
public class RxDrugsID implements Serializable {

    @Column(name="rxId")
    private String rxId;

    @Column(name="drugId")
    private String drugId;
}
