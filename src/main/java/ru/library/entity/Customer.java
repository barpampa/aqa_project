package ru.library.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int id;

    @Column(name = "first_name", length = 50)
    public String firstName;

    @Column(name = "second_name", length = 50)
    public String secondName;
}
