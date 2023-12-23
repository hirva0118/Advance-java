/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hirva
 */
public class Prepared {
    public static void main(String a[])
    {
        String url="jdbc:mysql://localhost:3306/newsql";
        String username="root";
        String password="";
        
         try
        {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newsql","root","");
            System.out.println("success 1");
            //Statement st=con.createStatement();
            
            //select query
            String selectQuery="select *from login where username=?";
            String initialU="hirva";
            PreparedStatement selectStatement=con.prepareStatement(selectQuery);
            selectStatement.setString(1,initialU);
            //Statement selectstatement=con.createStatement();
           
            ResultSet rs=selectStatement.executeQuery();
            while(rs.next())
            {
                String uname=rs.getString("username");
                String pass=rs.getString("password");
            } 
            System.out.println("success 2");
            
//            insert query
            String insertQuery="insert into login values(?,?)";
            String newU="Radhe";
            String newP="krishna";
            PreparedStatement insertStatement=con.prepareStatement(insertQuery);
            insertStatement.setString(1,newU);
            insertStatement.setString(2,newP);
            int rowsInserted=insertStatement.executeUpdate();
            
            //update query
//            String UpdateQuery="update login set password=? where username=?";
//            String updateP="shree";
//            String updateU="om";
            
//            PreparedStatement updateStatement=con.prepareStatement(UpdateQuery);
//            updateStatement.setString(1,updateP);
//            updateStatement.setString(2,updateU);
//            int rowsAffected=updateStatement.executeUpdate();
//            System.out.println("success 3");
        }
         catch(SQLException e)
         {
             e.printStackTrace();
         }
    }

   
    }

