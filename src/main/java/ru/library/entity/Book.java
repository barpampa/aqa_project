package ru.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public long id;

    @Column(name = "book_title", length = 100)
    public String bookTitle;

    @Column(name = "author_id")
    public long authorId;

    @Column(name = "customer_id")
    public long customerId;

}
