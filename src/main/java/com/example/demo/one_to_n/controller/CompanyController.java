package com.example.demo.one_to_n.controller;

import com.example.demo.one_to_n.dto.CompanyDto;
import com.example.demo.one_to_n.entity.Company;
import com.example.demo.one_to_n.repositroies.CompanyRepository;
import com.example.demo.one_to_n.repositroies.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 1:52 PM 7/26/2018
 * @Modified By:
 */
@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {
    private CompanyRepository companyRepository;

    private EmployeeRepository employeeRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Transactional
    @PostMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE)
    public Company save(@RequestBody Company company){
            company.getEmployees().stream().forEach(employee -> {employee.setCompany(company);});
        return companyRepository.save(company);

    }

    @Transactional
    @GetMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Company> findAll(){
        return  companyRepository.findAll();

    }

    @Transactional
    @PutMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Company company){
        company.getEmployees().stream().filter(employee -> employee.getId()==null)
                .forEach(employee -> {employee.setCompany(company);});
        companyRepository.save(company);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @Transactional
    @GetMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CompanyDto findById(@PathVariable Long id){
        Company company= companyRepository.findById(id).get();
        return new CompanyDto(company);

    }


    @Transactional
    @DeleteMapping (path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Company deleteById(@PathVariable Long id){
        Company company=companyRepository.findById(id).get();
        companyRepository.delete(company);
        return company;
    }



}
