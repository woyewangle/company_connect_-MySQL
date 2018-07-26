package com.example.demo.one_to_one.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @Author: 余锡鸿
 * @Description:
 * @Date: Create in 4:14 PM 7/26/2018
 * @Modified By:
 */
@Entity
public class Leader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //referencedColumnName：参考列名,默认的情况下是列表的主键
    @OneToOne(targetEntity = Klass.class)
    @JoinColumn(name = "id", referencedColumnName = "klass_id")
    private Klass klass;

    public Leader() {
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

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
