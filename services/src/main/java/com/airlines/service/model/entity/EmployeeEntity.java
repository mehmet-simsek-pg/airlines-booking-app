package com.airlines.service.model.entity;

import com.airlines.service.model.pojo.Address;
import com.airlines.service.model.pojo.Airport;
import com.airlines.service.model.pojo.Employee;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "contact", nullable = false)
    private String contact;

    @ManyToOne
    @JoinColumn(name = "airport_id", referencedColumnName = "id")
    private AirportEntity airport;

    public EmployeeEntity() {
    }

    public EmployeeEntity(final Long id) {
        this.id = id;
    }

    public EmployeeEntity(final Long id, final Address address) {
        this.id = id;
        this.address = new AddressEntity(address);
    }

    public EmployeeEntity(final Long id, final Airport airport) {
        this.id = id;
        this.airport = new AirportEntity(airport);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public AirportEntity getAirport() {
        return airport;
    }

    public void setAirport(AirportEntity airport) {
        this.airport = airport;
    }

    public Employee toEmployee() {

        final Employee result = new Employee();

        result.setId(getId());
        result.setName(getName());
        result.setAddress(getAddress().toAddress());
        result.setAge(getAge());
        result.setEmail(getEmail());
        result.setContact(getContact());
        result.setAirport(getAirport().toAirport());

        return result;
    }
}
