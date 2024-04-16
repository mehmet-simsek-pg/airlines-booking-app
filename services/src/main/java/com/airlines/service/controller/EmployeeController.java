package com.airlines.service.controller;

import com.airlines.service.model.pojo.Employee;
import com.airlines.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Employee>> getAll() {

        final List<Employee> result = service.loads();

        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<Employee> get(@PathVariable("id") final Long id) {

        final Employee result = service.load(id);

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody final Employee employee) {

        final Employee result = service.create(employee);

        return ResponseEntity.ok(result);
    }
}
