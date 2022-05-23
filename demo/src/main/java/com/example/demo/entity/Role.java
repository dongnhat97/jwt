package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class Role extends BaseEntity {
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String name;
}
