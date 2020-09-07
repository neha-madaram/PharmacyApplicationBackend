package com.deployments.Entities;

import com.deployments.EnitityID.RxDrugsID;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="RxDrugs")
@Data
@DynamicUpdate
public class RxDrugs {


    @EmbeddedId
    private RxDrugsID rxDrugsID;

    @Column(name="dosage")
    private int dosage;

    @Column(name="UnitsConsumedPerDay")
    private int unitsConsumedPerDay;

    @Column(name="unitOrdered")
    private int unitOrdered;



}
