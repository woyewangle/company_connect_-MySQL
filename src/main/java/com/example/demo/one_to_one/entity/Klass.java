package com.example.demo.one_to_one.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Klass {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @OneToOne(targetEntity = Leader.class)
    @JoinColumn(name = "id",referencedColumnName = "leader_id")
    private Leader leader;

    public Klass() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }
}
