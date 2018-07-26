package com.example.demo.n_to_n.controller;


import com.example.demo.n_to_n.entity.Group;
import com.example.demo.n_to_n.repositroies.Group_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {

    private final Group_Repository group_repository;

    @Autowired
    public GroupController(Group_Repository group_repository) {
        this.group_repository = group_repository;
    }

    @Transactional
    @GetMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Group> findAll() {
        return group_repository.findAll();
    }

    @Transactional
    @GetMapping(path="{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Group findById(@PathVariable Long id) {
        return group_repository.getOne(id);
    }

    @Transactional
    @PostMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE)
    public Group save(@RequestBody Group o) {
        return group_repository.save(o);
    }

    @Transactional
    @DeleteMapping(path="{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        group_repository.deleteById(id);
    }

    @Transactional
    @PutMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE)
    public Group update(@RequestBody Group o) {
        return group_repository.save(o);
    }
}
