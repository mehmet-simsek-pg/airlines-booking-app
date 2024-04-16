package com.airlines.service.model.entity;

import com.airlines.service.model.pojo.Airport;
import jakarta.persistence.*;

@Entity
@Table(name = "airport")
public class AirportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    public AirportEntity() {
    }

    public AirportEntity(Long id) {
        this.id = id;
    }

    public AirportEntity(final Airport airport) {
        this.id = airport.getId();
        this.code = airport.getCode();
        this.name = airport.getName();
        this.address = new AddressEntity(airport.getAddress());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public Airport toAirport() {

        final Airport result = new Airport();

        result.setId(getId());
        result.setCode(getCode());
        result.setName(getName());
        result.setAddress(getAddress().toAddress());

        return result;
    }
}
