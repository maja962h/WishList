package com.example.wishlist.repositories;

import com.example.wishlist.models.WishList;
import java.sql.*;
import java.util.ArrayList;

public class WishListHandler {

    private Connection con;
    private Statement stmt;
    private String sqlString;

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

    public ArrayList<WishList> fetchOneUsersWishlist(){
        ArrayList<WishList> allWishlists = new ArrayList<>();
        int id = 0;
        String name = "";
        String email = "";

        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            sqlString = "SELECT * FROM `Wishlist`";

            ResultSet allEmailResultSet = stmt.executeQuery(sqlString);
            while(allEmailResultSet.next()){
                id = Integer.parseInt(allEmailResultSet.getString(1));
                name = allEmailResultSet.getString(2);
                email = allEmailResultSet.getString(3);
                WishList wishlist = new WishList(id, name, email);
                allWishlists.add(wishlist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allWishlists;
    }

    public void connect () {
        String url = "jdbc:mysql://ilzyz0heng1bygi8.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/vkeg9sp1dznzifg5";

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
