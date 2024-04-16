package com.airlines.service.model.entity;

import com.airlines.service.model.pojo.Address;
import com.airlines.service.model.pojo.Gender;
import com.airlines.service.model.pojo.Passenger;
import jakarta.persistence.*;

@Entity
@Table(name = "passenger")
public class PassengerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    @Column(name = "age")
    private Integer age;

    @OneToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private GenderEntity gender;

    @Column(name = "contact")
    private String contact;

    public PassengerEntity() {
    }

    public PassengerEntity(final Long id) {
        this.id = id;
    }

    public PassengerEntity(final Long id, final Address address) {
        this.id = id;
        this.address = new AddressEntity(address);
    }

    public PassengerEntity(final Long id, final Gender gender) {
        this.id = id;
        this.gender = new GenderEntity(gender);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public GenderEntity getGender() {
        return gender;
    }

    public void setGender(GenderEntity gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Passenger toPassenger() {

        final Passenger result = new Passenger();

        result.setId(getId());
        result.setName(getName());
        result.setAddress(getAddress().toAddress());
        result.setAge(getAge());
        result.setGender(getGender().toGender());
        result.setContact(getContact());

        return result;
    }
}
