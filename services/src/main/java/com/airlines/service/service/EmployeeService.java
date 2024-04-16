package com.airlines.service.service;

import com.airlines.service.model.entity.AddressEntity;
import com.airlines.service.model.entity.AirportEntity;
import com.airlines.service.model.entity.EmployeeEntity;
import com.airlines.service.model.pojo.Employee;
import com.airlines.service.repository.AddressRepository;
import com.airlines.service.repository.AirportRepository;
import com.airlines.service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AirportRepository airportRepository;


    public List<Employee> loads() {
        return employeeRepository.findAll().stream().map(EmployeeEntity::toEmployee).collect(Collectors.toList());
    }

    public Employee load(final Long id) {

        return employeeRepository.findById(id).orElseThrow().toEmployee();
    }

    public Employee create(final Employee employee) {

        final EmployeeEntity result = new EmployeeEntity();
        final AddressEntity addressEntity = addressRepository.findById(employee.getAddress().getId()).orElseThrow();
        final AirportEntity airportEntity = airportRepository.findById(employee.getAirport().getId()).orElseThrow();

        result.setName(employee.getName());
        result.setAge(employee.getAge());
        result.setEmail(employee.getEmail());
        result.setContact(employee.getContact());
        result.setAddress(addressEntity);
        result.setAirport(airportEntity);

        employeeRepository.save(result);

        return result.toEmployee();
    }
}
