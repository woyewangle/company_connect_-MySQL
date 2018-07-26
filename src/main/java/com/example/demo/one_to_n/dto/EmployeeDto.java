package com.example.demo.one_to_n.dto;

import com.example.demo.one_to_n.entity.Employee;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 8:33 PM 7/26/2018
 * @Modified By:
 */
public class EmployeeDto {
    public final Long id;
    public final String employeeName;
    public final Long companyId;

    public Long getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public EmployeeDto(Employee employee) {
        this.id = employee.getId();
        this.employeeName = employee.getEmployeeName();
        this.companyId = employee.getCompany().getId();
    }
}
