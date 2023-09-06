package ru.library.steps.fixtures;

import io.qameta.allure.Step;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import ru.library.dbconfig.DBConfig;
import ru.library.entity.Author;
import ru.library.entity.Book;
import ru.library.repository.BookRepository;

import java.util.List;

public class LibraryDatabaseFixtureSteps {
    private final Session session;

    public LibraryDatabaseFixtureSteps() {
        this.session = DBConfig.getSessionFactory().openSession();
    }

    @Step("Создаем автора")
    public Author insertAuthor(String firstName, String secondName, String familyName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setSecondName(secondName);
        author.setFamilyName(familyName);

        Transaction tr = session.beginTransaction();
        session.persist(author);
        tr.commit();
        return author;
    }

    @Step("Создаем книгу")
    public void insertBookStep(String bookTitle, Long authorId) {
        BookRepository bookRepository = new BookRepository();
        bookRepository.insertBook(bookTitle,authorId);
    }

    @Step("Получаем книгу по id")
    public void getBookByIdStep(Long id) {
        BookRepository bookRepository = new BookRepository();
        Assertions.assertNotNull(bookRepository.getBookById(id),"Книга не найдена");
    }

    @Step("Получаем книгу по названию")
    public void getBookByTitleStep(String book_title) {
        BookRepository bookRepository = new BookRepository();
        bookRepository.getBookByTitle(book_title);

    }

    @Step("Удаляем все книги в таблице")
    public void deleteAllBookStep() {
       BookRepository bookRepository = new BookRepository();
       bookRepository.deleteAllBook();
    }

    @Step("Удаляем книгу")
    public void deleteBookByIdStep(Long id) {
        BookRepository bookRepository = new BookRepository();
        Book book = new Book();
        bookRepository.deleteBookById(id);
        Assertions.assertEquals(0, book.getId());
    }

    @Step("Считаем количество строк в таблице")
    public void countRowsStep(Long rows) {
        BookRepository bookRepository = new BookRepository();
        List<Book> results = bookRepository.findAllBook();
        Assertions.assertEquals(rows, results.size());
    }
}
