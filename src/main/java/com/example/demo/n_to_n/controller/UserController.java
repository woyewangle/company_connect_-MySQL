package com.example.demo.n_to_n.controller;


import com.example.demo.n_to_n.entity.User;
import com.example.demo.n_to_n.repositroies.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @GetMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    @GetMapping(path="{/id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public User findById(@PathVariable Long id) {
        return userRepository.getOne(id);
    }

    @Transactional
    @PostMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody User o) {
        return userRepository.save(o);
    }

    @Transactional
    @DeleteMapping(path="{/id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @PutMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE)
    public User update(@RequestBody User o) {
        return userRepository.save(o);
    }

}
