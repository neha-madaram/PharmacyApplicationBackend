package com.deployments.Entities;

import com.deployments.EnitityID.RxRequestID;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Table(name="PrescriptionRequest")
@Component
@Immutable
public class RxRequest implements Persistable<RxRequestID> {

    @EmbeddedId
    private RxRequestID prescriptionRequestID;

    @Transient
    private boolean update;

   @Column(name="comments")
    private String comments;

   @Column(name="priority")
   private String priority;

    /*@Override
    public RxRequestID getId() {
        return this.prescriptionRequestID;
    }*/

    /*public void setId(RxRequestID id) {
        this.prescriptionRequestID = id;
    }*/

    @Override
    public RxRequestID getId() {
        return this.prescriptionRequestID;
    }

    public void setId(RxRequestID rxRequestID){ this.prescriptionRequestID = rxRequestID;}

    @Override
    public boolean isNew() {
        return !this.update;
    }


}
