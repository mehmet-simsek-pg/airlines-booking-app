package com.airlines.service.model.pojo;

public class Airfare {

    private Long id;

    private Integer charge_amount;

    private String description;

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
}
