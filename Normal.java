/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hirva
 */
public class Normal {
    public static void main(String args[]) throws ClassNotFoundException
    {
        String url="jdbc:mysql://localhost:3306/newsql";
        String username="root";
        String password="";
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newsql","root","");
            System.out.println("success");
            Statement st=con.createStatement();
            
            //select query
            String selectQuery="SELECT * FROM login";
            ResultSet rs=st.executeQuery(selectQuery);
            
            while(rs.next())
            {
                String uname=rs.getString("username");
                String pass=rs.getString("password");
            }
            //insert query
            String insertQuery="insert into login values('hare','ram')";
            int rowsAffected=st.executeUpdate(insertQuery);

            //update query
            String updateQuery="update login set username='harii' where password='ram'";
            rowsAffected = st.executeUpdate(updateQuery);
            
            //delete query
            String deleteQuery="delete from login where username='harii'";
            rowsAffected=st.executeUpdate(deleteQuery);
        }
        catch(SQLException e){
            
            e.printStackTrace();
        }
    }
    
}
