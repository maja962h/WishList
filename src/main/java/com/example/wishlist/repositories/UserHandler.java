package com.example.wishlist.repositories;

import java.sql.*;

public class UserHandler {

    private Connection con;
    private Statement stmt;
    private String sqlString;
    private ResultSet rs;

    public UserHandler(){
        connect();
    }

    public void createUser(String email, String password, String name){
        try
        {
            stmt = con.createStatement();
            sqlString = ("INSERT INTO `you_wish`.`Users` (`user_email`, `user_password`, `user_name`) " +
                    "VALUES ('" + email + "', '" + password + "', '" + name + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateUser(){

    }

    public void deleteUser(){

    }

    public void connect () {
        String url = "jdbc:mysql://localhost:3306/you_wish";

        try {
            con = DriverManager.getConnection(url,"root","testtest");
        }
        catch(Exception e) {
            System.out.println("There is no connection to the database");
            e.printStackTrace();
        }
        System.out.println("There is a successful connection.");
    }
}
