package com.example.demo.one_to_n.repositroies;

import com.example.demo.one_to_n.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 7:45 PM 7/26/2018
 * @Modified By:
 */
@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long>{
}
