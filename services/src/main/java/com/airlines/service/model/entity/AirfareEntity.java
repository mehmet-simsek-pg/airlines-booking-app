package com.airlines.service.model.entity;

import com.airlines.service.model.pojo.Airfare;
import jakarta.persistence.*;

@Entity
@Table(name = "airfare")
public class AirfareEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "charge_amount", nullable = false)
    private Integer charge_amount;

    @Column(name = "description", nullable = false)
    private String description;

    public AirfareEntity() {
    }

    public AirfareEntity(Long id) {
        this.id = id;
    }

    public AirfareEntity(final Airfare airfare) {

        this.charge_amount = airfare.getCharge_amount();
        this.description = airfare.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCharge_amount() {
        return charge_amount;
    }

    public void setCharge_amount(Integer charge_amount) {
        this.charge_amount = charge_amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Airfare toAirfare() {

        final Airfare airfare = new Airfare();

        airfare.setId(getId());
        airfare.setCharge_amount(getCharge_amount());
        airfare.setDescription(getDescription());

        return airfare;
    }
}
