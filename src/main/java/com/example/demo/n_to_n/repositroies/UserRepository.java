package com.example.demo.n_to_n.repositroies;


import com.example.demo.n_to_n.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
