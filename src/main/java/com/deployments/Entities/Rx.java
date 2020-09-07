package com.deployments.Entities;

import com.deployments.EnitityID.RxID;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Component
@DynamicUpdate
@Table(name="Rx")
@Data
public class Rx {

    @EmbeddedId
    private RxID rxID;

    @Column(name="rxExpired")
    private Date rxExpired;

    @Column(name="prescriberId")
    private String prescriberId;

    @Column(name="active")
    private String active;

}
