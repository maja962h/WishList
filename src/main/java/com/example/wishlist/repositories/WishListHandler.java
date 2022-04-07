package com.example.wishlist.repositories;

import com.example.wishlist.models.WishList;

import java.sql.*;
import java.util.ArrayList;

public class WishListHandler {

    private Connection con;
    private Statement stmt;
    private String sqlString;
    private ResultSet rs;

    public WishListHandler(){
        connect();
    }

    public void createWishList(WishList wishList){
        String name = wishList.getName();
        String email = wishList.getUserEmail();

        try
        {
            stmt = con.createStatement();
            sqlString = ("INSERT INTO `vkeg9sp1dznzifg5`.`wishlist` (`wishlist_name`, `user_email`) " +
                    "VALUES ('" + name + "', '" + email + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateWishListName(String name, int wishListId){
        try {
            stmt = con.createStatement();
            sqlString = ("UPDATE `vkeg9sp1dznzifg5`.`wishlist` SET `wishList_name` =  '" + name + "' WHERE (`wishlist_id` = '" + wishListId + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteWishList(int wishListID){
        try {
            stmt = con.createStatement();
            sqlString = ("DELETE FROM `vkeg9sp1dznzifg5`.`wishlist` WHERE (`wishlist_id` = '" + wishListID + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> fetchOneUsersWishlist(String email){
        ArrayList<String> allWishlists = new ArrayList<>();
        String id = "";
        String name = "";

        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            sqlString = "SELECT `user_email`, `wishList_id` FROM `WishList` WHERE (`user_email` = '" + email + "')";

            ResultSet allEmailResultSet = stmt.executeQuery(sqlString);
            while(allEmailResultSet.next()){
                id = allEmailResultSet.getString(1);
                name = allEmailResultSet.getString(2);
                email = allEmailResultSet.getString(3);
                allWishlists.add(id);
                allWishlists.add(name);
                allWishlists.add(email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allWishlists;
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
