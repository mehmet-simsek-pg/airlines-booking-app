package com.airlines.service.model.entity;

import com.airlines.service.model.pojo.Airplane;
import jakarta.persistence.*;

@Entity
@Table(name="airplane")
public class AirplaneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "serial")
    private Long id;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @Column(name = "company", nullable = false)
    private String company;

    public AirplaneEntity() {
    }

    public AirplaneEntity(Long id) {
        this.id = id;
    }

    public AirplaneEntity(final Airplane airplane) {
        this.capacity = airplane.getCapacity();
        this.weight = airplane.getWeight();
        this.company = airplane.getCompany();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Airplane toAirplane() {
        final Airplane airplane = new Airplane();

        airplane.setId(getId());
        airplane.setCapacity(getCapacity());
        airplane.setWeight(getWeight());
        airplane.setCompany(getCompany());

        return airplane;
    }
}
