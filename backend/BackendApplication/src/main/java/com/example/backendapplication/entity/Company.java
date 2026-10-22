package com.aimockinterview.backend.entity;
import jakarta.persistence.*;
@Entity @Table(name="companies")
public class Company {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer id;
 @Column(nullable=false) private String name;
 protected Company() {}
 public Integer getId() { return id; }
 public String getName() { return name; }
}
