package com.tatkal.dao;

import java.sql.*;
import com.tatkal.model.User;
import com.tatkal.db.DBConnection;

public class UserDAO
{
    public void registerUser(User u)
    {
         Connection conn = null;
          PreparedStatement ps = null;
        try
        {
            conn = DBConnection.getConnection();
           String query = "INSERT INTO users(name,email,password,phone_number)Values(?,?,?,?)";

             ps =conn.prepareStatement(query);
        
             ps.setString(1,u.getName());
             ps.setString(2,u.getEmail());
             ps.setString(3,u.getPassword());
             ps.setString(4,u.getPhoneNumber());

             ps.executeUpdate();
        }
        catch(SQLException e) 
        {
             if(e.getMessage().contains("Duplicate entry")) 
                {
               System.out.println("Email already registered!");
                }
            else 
                {
                   e.printStackTrace();
                }
        }

        finally
        {
            try
            {
            if(ps!=null)ps.close();
            if(conn!=null)conn.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }

        }
    }
    public User loginUser(String email,String password)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            conn = DBConnection.getConnection();
            String query = "SELECT * FROM users WHERE email=? AND password=?";
            ps = conn.prepareStatement(query);
            
             ps.setString(1,email);
             ps.setString(2,password);
             rs = ps.executeQuery();
            if(rs.next())
            {
              int id = rs.getInt("user_id");
              String name = rs.getString("name");
              String dbEmail = rs.getString("email");
              String dbPassword = rs.getString("password");
              String phoneNumber =rs.getString("phone_number"); 
              
              return new User(id,name,dbEmail,dbPassword,phoneNumber);
            }
            else
            {
                return null;
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        finally
        {
            try
            {
                if(rs!=null)rs.close();
                if(ps!=null)ps.close();
                if(conn!=null)conn.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return null;

        
    }

}