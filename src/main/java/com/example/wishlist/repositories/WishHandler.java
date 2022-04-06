package com.example.wishlist.repositories;


import com.example.wishlist.models.Wish;

import java.sql.*;

public class WishHandler {

    private Connection con;
    private Statement stmt;
    private String sqlString;
    private ResultSet rs;

    public WishHandler(){
        connect();
    }

    public void createWish(Wish wish){
        String name = wish.getWishName();
        String description = wish.getDescription();
        int price = wish.getPrice();
        int wishListId = wish.getWishListID();

        try
        {
            stmt = con.createStatement();
            sqlString = ("INSERT INTO `you_wish`.`wish` (`wish_name`, `wish_price`, `wish_description` , `WishList_id`) " +
                    "VALUES ('" + name + "','" + price + "','" + description + "','" + wishListId + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateWishName(String name, int wishId){
        try {
            stmt = con.createStatement();
            sqlString = ("UPDATE `you_wish`.`wish` SET `wish_name` =  '" + name + "' WHERE (`wish_id` = '" + wishId + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteWish(int wishID){
        try {
            stmt = con.createStatement();
            sqlString = ("DELETE FROM `you_wish`.`wish` WHERE (`wish_id` = '" + wishID + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e) {
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
