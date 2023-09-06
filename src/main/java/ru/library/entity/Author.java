package ru.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int id;

    @Column(name = "first_name", length = 50, nullable = false)
    public String firstName;

    @Column(name = "family_name", length = 50)
    public String familyName;

    @Column(name = "second_name", length = 50, nullable = false)
    public String secondName;

}
