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
            sqlString = ("INSERT INTO `vkeg9sp1dznzifg5`.`wish` (`wish_name`, `wish_price`, `wish_description` , `wishlist_id`) " +
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
            sqlString = ("UPDATE `vkeg9sp1dznzifg5`.`wish` SET `wish_name` =  '" + name + "' WHERE (`wish_id` = '" + wishId + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateWishDescription(String description, int wishId){
        try {
            stmt = con.createStatement();
            sqlString = ("UPDATE `vkeg9sp1dznzifg5`.`wish` SET `wish_description` =  '" + description + "' WHERE (`wish_id` = '" + wishId + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateWishPrice(int price, int wishId){
        try {
            stmt = con.createStatement();
            sqlString = ("UPDATE `vkeg9sp1dznzifg5`.`wish` SET `wish_price` =  '" + price + "' WHERE (`wish_id` = '" + wishId + "')");
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
            sqlString = ("DELETE FROM `vkeg9sp1dznzifg5`.`wish` WHERE (`wish_id` = '" + wishID + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void connect () {
        String url = "jdbc:mysql://ilzyz0heng1bygi8.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/vkeg9sp1dznzifg5";
        //mysql://username:password@URL:3306/databaseNavn
        //kun lave tables, ikke schema
        //JDBC:mysql://URL:3306/databaseNavn
        //mysql://qfaq4ga0w47q0kof:fubkr4yeaamcpzrn@ilzyz0heng1bygi8.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/vkeg9sp1dznzifg5


        try {
            con = DriverManager.getConnection(url,"qfaq4ga0w47q0kof","fubkr4yeaamcpzrn");
        }
        catch(Exception e) {
            System.out.println("There is no connection to the database");
            e.printStackTrace();
        }
        System.out.println("There is a successful connection.");
    }
}
