package ru.library.dbconfig;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.library.entity.Author;
import ru.library.entity.Book;
import ru.library.entity.Customer;

public class DBConfig {

    private static SessionFactory sessionFactory; //  создание Session экземпляров. Интерфейс org.hibernate.Session
    // является мостом между приложением и Hibernate. С помощью сессий выполняются все CRUD-операции с объектами-сущностями.

    private DBConfig() {} //зачем это?

    public static SessionFactory getSessionFactory() { //
        if (sessionFactory == null) {
            try {
                //Configuration позволяет приложению
                // указывать свойства и документы сопоставления, которые будут использоваться при создании SessionFactory
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Author.class).addAnnotatedClass(Book.class).addAnnotatedClass(Customer.class);
                //Сервисы, которые потребуются Hibernate во время начальной загрузки и во время выполнения
                //берет настройки конфигурации из hibernate.cfg.xml и применяет их
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}











