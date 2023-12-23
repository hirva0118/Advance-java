/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static java.sql.Types.VARCHAR;

/**
 *
 * @author hirva
 */
public class Callable {
     public static void main(String a[])
    {
        String url="jdbc:mysql://localhost:3306/newsql";
        String username="root";
        String password="";
        
         try
         {
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newsql","root","");
               System.out.println("success 1");
               String callProcedure="{call get_login_details(?,?)}";
               CallableStatement cst=con.prepareCall(callProcedure);
               
               String uname1="mom";
               cst.setString(1,uname1);
               cst.registerOutParameter(2,VARCHAR);
               cst.execute();
               String pass1=cst.getString(2);
               System.out.println("sucess 2");
         }
         catch(SQLException e)
         {
             e.printStackTrace();
         }
}
}
