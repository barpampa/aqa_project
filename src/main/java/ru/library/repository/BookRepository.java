package ru.library.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.library.dbconfig.DBConfig;
import ru.library.entity.Book;

import java.util.List;

public class BookRepository {

    Session session;

    public BookRepository() {
        this.session = DBConfig.getSessionFactory().openSession();
    }

    public Book getBookById(Long id) {
        Transaction tr = session.beginTransaction();
        Book results = session.get(Book.class, id);
        session.flush();
        session.clear();
        tr.commit();
        session.close();
        System.out.println(results);
        return results;
    }

    public void getBookByTitle(String bookTitle) {
        final String hql = "FROM Book b WHERE b.bookTitle =: Test1";

        Query query = session.createQuery(hql, Book.class);
        query.setParameter("Test1", bookTitle);
        Transaction tr = session.beginTransaction();
        tr.commit();
        System.out.println(bookTitle);
    }

    public List<Book> findAllBook() {
        final String hql = """
                SELECT * FROM Book
                """;

        List<Book> results = session.createNativeQuery(hql, Book.class).list();
        Transaction tr = session.beginTransaction();
        tr.commit();
        System.out.println(results);
        return results;
    }

    public void insertBook(String bookTitle, Long authorId) {
        Book book = new Book();
        book.setBookTitle(bookTitle);
        book.setAuthorId(authorId);

        Transaction tr = session.beginTransaction();
        session.persist(book);
        session.flush();
        session.clear();
        tr.commit();
        session.close();
    }

    public void deleteBookById(Long id) throws IllegalArgumentException{
    try {
        Transaction tr = session.beginTransaction();
        Book book = session.get(Book.class, id);
        session.remove(book);
        session.flush();
        session.clear();
        tr.commit();
        session.close();
    } catch (IllegalArgumentException e) {
        System.out.println("Нет такой книги");
        }
    }

    public void deleteAllBook() {
        final String hql = """
                DELETE FROM book
                """;

        Transaction tr = session.beginTransaction();
        session.createNativeQuery(hql, Book.class)
                .executeUpdate();
        tr.commit();
    }
}
