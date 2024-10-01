package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.PrintWriter;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
}
