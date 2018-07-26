package com.example.demo.one_to_n.dto;

import com.example.demo.one_to_n.entity.Company;
import com.example.demo.one_to_n.entity.Employee;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 8:23 PM 7/26/2018
 * @Modified By:
 */
public class CompanyDto {
    public final Long id;
    public final String companyName;
    public final Long employeeNumber;
    public final List<EmployeeDto> employees;

    public CompanyDto(Company company) {
        this.id = company.getId();
        this.companyName = company.getCompanyName();
        this.employeeNumber = company.getEmployeeNumber();
        this.employees = company.getEmployees().stream().map(employee -> new EmployeeDto(employee)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }
}
