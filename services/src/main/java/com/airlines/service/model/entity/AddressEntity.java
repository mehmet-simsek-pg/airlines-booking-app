package com.airlines.service.model.entity;

import com.airlines.service.model.pojo.Address;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "street_number")
    private String street_number;

    @Column(name = "state")
    private String state;

    @ManyToOne()
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private CountryEntity country;

    public AddressEntity() {
    }

    public AddressEntity(Long id) {
        this.id = id;
    }

    public AddressEntity(final Address address) {

        this.street_number = address.getStreet_number();
        this.state = address.getState();
        this.country = new CountryEntity(address.getCountry());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public Address toAddress() {

        final Address result = new Address();

        result.setId(getId());
        result.setStreet_number(getStreet_number());
        result.setState(getState());
        result.setCountry(getCountry().toCountry());

        return result;
    }
}
