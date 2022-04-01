package com.example.wishlist.repositories;

import java.sql.*;

public class WishListHandler {

    private Connection con;
    private Statement stmt;
    private String sqlString;
    private ResultSet rs;

    public WishListHandler(){
        connect();
    }

    public void createWishList(String name, String email){

        try
        {
            stmt = con.createStatement();
            sqlString = ("INSERT INTO `you_wish`.`wishList` (`wishlist_name`, `user_email`) " +
                    "VALUES ('" + name + "', '" + email + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void showWishList(){

    }

    public void updateWishList(){

    }

    public void deleteWishList(){

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
