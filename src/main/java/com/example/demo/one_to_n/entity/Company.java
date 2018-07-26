package com.example.demo.one_to_n.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 6:48 PM 7/24/2018
 * @Modified By:
 */
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String companyName;
    public Long employeeNumber;

    public Company(){}

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company",fetch = FetchType.LAZY)
    public List<Employee> employees=new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long EmployeeNumber) {
        this.employeeNumber = EmployeeNumber;
    }

}
