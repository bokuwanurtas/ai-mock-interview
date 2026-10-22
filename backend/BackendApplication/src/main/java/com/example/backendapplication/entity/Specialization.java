package com.aimockinterview.backend.entity;
import jakarta.persistence.*;
@Entity @Table(name="specializations")
public class Specialization {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer id;
 @Column(nullable=false) private String name;
 protected Specialization() {}
 public Integer getId() { return id; }
 public String getName() { return name; }
}
