package ru.library.dbconfig;

import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@NoArgsConstructor
public class DBConfig {

    public static SessionFactory sessionFactory;  //переменная класса "фабрики"
    public static SessionFactory getSessionFactory() { //получить "фабрику"
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration()
                        .configure("hibernate.cfg.xml");
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}

