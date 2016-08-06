package com.schoolofnet.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "task")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    public Task() {

    }

    public Task(String name) {
        this.name = name;
    }

    public void setId(Integer _id) {
        this.id = _id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getName() {
        return this.name;
    }
}
