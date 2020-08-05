package com.deployments.Entities;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "drugs")
public class Drugs {
    @Id
    private int drugId;

    @Column(name = "drugName")
    private String drugName;

    @Column(name = "pricePerUnit")
    private int priceperUnit;

    @Column(name = "availability")
    private boolean available;

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getPriceperUnit() {
        return priceperUnit;
    }

    public void setPriceperUnit(int priceperUnit) {
        this.priceperUnit = priceperUnit;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }



}