package com.example.demo1.Book;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {

    public static Connection connectDb(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "pass"); // address, database username, database password
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }

}
