package com.example.demo.one_to_one.controller;

import com.example.demo.one_to_one.entity.Leader;
import com.example.demo.one_to_one.repositroies.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@RequestMapping("/api/v1/leaders")
public class LeaderController {
    private final LeaderRepository leaderRepository;

    @Autowired
    public LeaderController(LeaderRepository leaderRepository) {
        this.leaderRepository = leaderRepository;
    }

    @Transactional
    @GetMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Leader> findAll() {
        return leaderRepository.findAll();
    }

    @Transactional
    @GetMapping(path="{/id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Leader findById(@PathVariable Long id) {
        return leaderRepository.findById(id).get();
    }

    @PostMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE)
    public Leader add(@RequestBody Leader leader) {
        return leaderRepository.save(leader);
    }

    @DeleteMapping(path="{/id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void destroy(@PathVariable Long id) {
        leaderRepository.deleteById(id);
    }

    @PutMapping(path="{/id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Leader update(@RequestBody Leader leader) {
        return leaderRepository.save(leader);
    }

}
