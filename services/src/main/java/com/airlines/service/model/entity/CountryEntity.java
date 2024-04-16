package com.airlines.service.model.entity;

import com.airlines.service.model.pojo.Country;
import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    public CountryEntity() {
    }

    public CountryEntity(Long id) {
        this.id = id;
    }

    public CountryEntity(final Country country) {

        this.code = country.getCode();
        this.name = country.getName();
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

    public Country toCountry() {
        final Country country = new Country();

        country.setId(getId());
        country.setCode(getCode());
        country.setName(getName());

        return country;
    }
}
