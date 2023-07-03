package ru.learnHub.Task22_BookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {
//		SpringApplication.run(BookStoreApplication.class, args);
        //Данные для подключения к БД Postgre (на локальном диске)
        String hostName = "localhost";              // имя хоста по умолчанию
        String port = "5432";                       //порт БД
        String dbName = "Task23_JAVA2_books_story"; //имя БД
        String user = "postgres";                   //имя user по умолчанию для БД Postgre
        String password = "postgres";               //password

        String connectionURL = "jdbc:postgresql://" + hostName + ":" + port + "/" + dbName;

//        String query1 = "ALTER SCHEMA bookstore RENAME TO book_store;";
        String query2 = "DROP SCHEMA IF EXISTS bookStore, book_store CASCADE;";
        String query3 = "DROP TABLE IF EXISTS book_store.author;";

        try {
            Class.forName("org.postgresql.Driver");  //Регистрация драйвера
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(connectionURL, user, password);
             Statement statement = connection.createStatement()) {
             statement.execute(query3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
