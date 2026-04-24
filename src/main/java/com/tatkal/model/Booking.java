package com.tatkal.model;
import java.sql.Timestamp;
public class Booking
{
    private int bookingId;
    private int userId;
    private int seatId;
    private Timestamp bookingTime;
    private String status;

    public Booking(int bookingId, int userId,
        int seatId, Timestamp bookingTime,
        String status)
    {
        this.bookingId = bookingId;
        this.userId = userId;
        this.seatId = seatId;
        this.bookingTime = bookingTime;
        this.status = status;
    }
  
    public int getBookingId()
    {
        return bookingId;
    }
    public void setBookingId(int bookingId)
    {
        this.bookingId = bookingId;
    }
    public int getUserId()
    {
        return userId ;
    }
    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    public int getSeatId()
    {
        return seatId;
    }
    public void setSeatId(int seatId)
    {
        this.seatId = seatId;
    }
    public Timestamp getBookingTime()
    {
        return bookingTime;
    }
    public void setBookingTime(Timestamp bookingTime)
    {
        this.bookingTime = bookingTime;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
}