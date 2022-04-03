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

    public void updateUserName(String email, String name){
        try
        {
            stmt = con.createStatement();
            sqlString = ("UPDATE `you_wish`.`Users` SET `user_name` =  '" + name + "' WHERE (`user_email` = '" + email + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateUserPassword(String email, String password){
        //UPDATE `you_wish`.`users` SET `user_name` = 'hejsa' WHERE (`user_email` = 'hej@123.dk');
        try
        {
            stmt = con.createStatement();
            sqlString = ("UPDATE `you_wish`.`Users` SET `user_password` =  '" + password + "' WHERE (`user_email` = '" + email + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteUser(String email){
        //DELETE FROM `you_wish`.`users` WHERE (`user_email` = 'niasd');
        try
        {
            stmt = con.createStatement();
            sqlString = ("DELETE FROM `you_wish`.`Users` WHERE (`user_email` = '" + email + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

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
