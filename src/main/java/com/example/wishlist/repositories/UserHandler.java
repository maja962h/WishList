package com.example.wishlist.repositories;

import com.example.wishlist.models.User;

import java.sql.*;

public class UserHandler {

    private Connection con;
    private Statement stmt;
    private String sqlString;
    private ResultSet rs;

    public UserHandler(){
        connect();
    }

    public void createUser(User user){
        String email = user.getEmail();
        String name = user.getName();
        String password = user.getPassword();

        try
        {
            stmt = con.createStatement();
            sqlString = ("INSERT INTO `vkeg9sp1dznzifg5`.`users` (`user_email`, `user_password`, `user_name`) " +
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
        try {
            stmt = con.createStatement();
            sqlString = ("UPDATE `vkeg9sp1dznzifg5`.`users` SET `user_name` =  '" + name + "' WHERE (`user_email` = '" + email + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserPassword(String email, String password){
        try {
            stmt = con.createStatement();
            sqlString = ("UPDATE `vkeg9sp1dznzifg5`.`users` SET `user_password` =  '" + password + "' WHERE (`user_email` = '" + email + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String email){
        try {
            stmt = con.createStatement();
            sqlString = ("DELETE FROM `vkeg9sp1dznzifg5`.`users` WHERE (`user_email` = '" + email + "')");
            stmt.executeUpdate(sqlString);
            System.out.println(sqlString);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }


    // will be used for login
    public boolean validateLoginInformation(String email, String password){
        boolean isAMatch = false;


        try{
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sqlString = "SELECT * FROM vkeg9sp1dznzifg5.users WHERE `user_email`= '" + email + "' AND `user_password`='" + password + "';";
            ResultSet rsVerify = stmt.executeQuery(sqlString);

            while (rsVerify.next()) {
                if(password.equals(rsVerify.getString("user_password")) && email.equals(rsVerify.getString("user_email"))){
                    isAMatch = true;
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return isAMatch;
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
