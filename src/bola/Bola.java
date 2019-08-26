/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bola;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.sql.Statement;

/**
 *
 * @author Asus
 * 
 * 
 */



public class Bola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Bola Oh Bola");
        System.out.println("Mengapa Engkau Bola?");
        
        Connection conn = null;
        try {
    // db parameters
            String url       = "jdbc:mysql://localhost:3306/fishkioskdatabase";
            String user      = "root";
            String password  = "";
    
    // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
    // more processing here
    // ... 
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
        try{
            if(conn != null){
                Statement stmt = conn.createStatement();
                String q = "SELECT * FROM memberships";
                String q1 = "INSERT INTO `memberships` "
                        + "(`user_id`, `username`, `password`, `email`, `role`, `join_date`, `fullname`, `balance`) "
                        + "VALUES (5, 'mbak ball', "
                        + "'password_mbak ball', 'mbakball@gmail.com', "
                        + "'seller', '2019-08-23', 'Mbak Ball', '60000')";
                String q3 = "UPDATE memberships SET password='password_mbak_ball' WHERE user_id=5";
                //ResultSet s = stmt.executeQuery(q); 
                int x = stmt.executeUpdate(q1);
                x = stmt.executeUpdate(q3);
                boolean first = true;
                for(ResultSet s = stmt.executeQuery(q);s!=null;s.next()){
                    if(first){
                        first=false;
                        continue;
                    }
                    System.out.println(s.getString(1)+" "+s.getString(2)+" "+s.getString(3));
                    
                }
             conn.close();
               
            }
           
        }catch(SQLException ex){
           System.out.println(ex.getMessage());
        }
        }
        
        
    }
}
    
    

