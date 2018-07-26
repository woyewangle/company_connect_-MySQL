package com.example.demo.one_to_one.repositroies;

import com.example.demo.one_to_one.entity.Leader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 9:51 PM 7/26/2018
 * @Modified By:
 */
@Repository
public interface LeaderRepository extends JpaRepository <Leader,Long>{
}
