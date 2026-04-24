package com.tatkal.dao;

import java.sql.*;
import java.util.*;
import com.tatkal.model.Train;
import com.tatkal.db.DBConnection;

public class TrainDAO
{
    public List<Train> getAllTrains()
    {
       List<Train> trains = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
             conn = DBConnection.getConnection();
             String query = "SELECT * FROM trains";
               ps = conn.prepareStatement(query);
               rs = ps.executeQuery();

        while(rs.next())
        {
            int id = rs.getInt("train_id");
            String name = rs.getString("name");
            int seats = rs.getInt("totalSeats");
            String boarding = rs.getString("boarding");
            String destination = rs.getString("destination");

            Train t = new Train(id,name,seats,boarding,destination);

            trains.add(t);
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
        return trains;
    }
}