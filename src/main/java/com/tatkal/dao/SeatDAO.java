package com.tatkal.dao;
import java.sql.*;
import java.util.*;
import com.tatkal.model.Seat;
import com.tatkal.db.DBConnection;

public class SeatDAO
{
    public List<Seat> getAvailableSeats(int trainId)
    {
        List<Seat> seats = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            conn = DBConnection.getConnection();
            String query = "SELECT * FROM seats WHERE train_id = ? AND status='Available'";
            ps = conn.prepareStatement(query);
            ps.setInt(1,trainId);
            rs = ps.executeQuery();
           
            
            while(rs.next())
            {
                int seatId = rs.getInt("seat_id");
                int dbtrainId = rs.getInt("train_id");
                int seatNumber = rs.getInt("seat_number");
                String status = rs.getString("status");

                Seat s = new Seat(seatId,dbtrainId,seatNumber,status);
                seats.add(s);
      
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
        return seats;
    }

    public boolean bookSeat(int seatId,int userId)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            conn =DBConnection.getConnection();
            conn.setAutoCommit(false);

            String checkQuery = "SELECT * FROM seats WHERE seat_id =? FOR UPDATE";
            ps = conn.prepareStatement(checkQuery);
            ps.setInt(1,seatId);
            rs = ps.executeQuery();

            if(rs.next())
            {
                String status = rs.getString("status");
                
                if(status.equals("Available"))
                {
                   PreparedStatement ps2=conn.prepareStatement("UPDATE seats SET status='Booked' WHERE seat_id=?");
                   ps2.setInt(1,seatId);
                   ps2.executeUpdate();
                   ps2.close();


                PreparedStatement ps3 = conn.prepareStatement("INSERT INTO bookings(user_id,seat_id,status) VALUES(?,?,'Confirmed')");
                ps3.setInt(1,userId);
                ps3.setInt(2,seatId);
                ps3.executeUpdate();
                ps3.close();

                conn.commit();
                return true;
            }
            else
            {
                System.out.println("Seat already booked!");
                conn.rollback();
                return false;
            }
        }
    }
        catch(SQLException e)
        {
            try
            {
                if(conn!=null)conn.rollback();
            }
            catch(SQLException ex)
            {
            ex.printStackTrace();
            }
        }
        finally 
        {
            try
            {
                if(conn!=null)conn.setAutoCommit(true);
                 if(rs!=null)rs.close();
                if(ps!=null)ps.close();
                if(conn!=null)conn.close();
            }
              catch(SQLException e)
               {
                    e.printStackTrace();
               }
        }
       return false;
    
}
}