package ru.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    public int id;

    @Column(name = "first_name", length = 50, nullable = false)
    public String firstName;

    @Column(name = "family_name", length = 50)
    public String familyName;

    @Column(name = "second_name", length = 50, nullable = false)
    public String secondName;

}
