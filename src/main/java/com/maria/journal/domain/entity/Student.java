package com.maria.journal.domain.entity;

import jakarta.persistence.*;


@Entity

@Table(name = "student")

public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "groupp")
    private int groupp;

    public Student(String name, int groupp) {
        this.name = name;
        this.groupp = groupp;
    }

    public int getGroup() {
        return groupp;
    }

    public void setGroup(int groupp) {
        this.groupp = groupp;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student() {
        name = "Безымянный";
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
       this.name=name;
    }

}

