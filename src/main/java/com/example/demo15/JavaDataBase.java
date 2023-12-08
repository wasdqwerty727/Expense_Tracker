package com.example.demo15;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaDataBase {
    private static Connection con;
    public Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/javafx";
        String user = "postgres";
        String password = "databasesql";
        try{
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected");
        } catch (SQLException e){
            System.out.println(e.toString());}
        return con;
    }
    public static void writeToDatabase(String userName, String userEmail, String userPassword){
        String name = userName;
        String email = userEmail;
        String pass = userPassword;

        String query = "INSERT INTO worker(name, email, password) VALUES(?, ?, ?)";
        try{
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, pass);
            pst.executeUpdate();
            System.out.println("Sucessfully created!");
        } catch (SQLException e){
            Logger lgr = Logger.getLogger(JavaDataBase.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }

    }
    public void closeConnection(){
        try{
            if (con != null && !con.isClosed()){
                con.close();
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
    }
}
