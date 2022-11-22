package com.example.demo.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {

    public Employee(String surname, Date dr, Boolean gender, double salary, int children) {
        this.surname = surname;
        this.dr = dr;
        this.gender = gender;
        this.salary = salary;
        this.children = children;
    }

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String surname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date dr;
    @Column(nullable = false)
    private Boolean gender;
    private Double salary;
    private int children;



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDR() {
        return dr;
    }
    public void setDR(Date dr) {
        this.dr = dr;
    }

    public Boolean getGender() {
        return gender;
    }
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getChildren() {return children;}
    public void setChildren(int children){this.children=children;}


}


