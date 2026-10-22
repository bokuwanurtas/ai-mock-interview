package com.aimockinterview.backend.entity;
import jakarta.persistence.*;
@Entity @Table(name="technologies")
public class Technology {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer id;
 @Column(nullable=false) private String name;
 protected Technology() {}
 public Integer getId() { return id; }
 public String getName() { return name; }
}
