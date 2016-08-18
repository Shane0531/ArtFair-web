package com.sylc.controller.restapi;

import com.sylc.model.Employee;
import com.sylc.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
  @Autowired
  EmployeeRepository em;

  @RequestMapping("/api/employees")
  public Iterable<Employee> findAllEmployee(){
    return em.findAll();
  }
}
