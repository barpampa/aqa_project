package ru.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    public int id;

    @Column(name = "book_title", length = 100)
    public String bookTitle;

    @Column(name = "author_id")
    public int authorId;

    @Column(name = "customer_id")
    public int customerId;

}
