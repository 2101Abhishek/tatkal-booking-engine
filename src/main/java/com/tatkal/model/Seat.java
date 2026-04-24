package com.tatkal.model;

public class Seat
{
    private int seatId;
    private int trainId;
    private int seatNumber;
    private String status;

    public Seat(int seatId, int trainId, int seatNumber,
        String status)
    {
        this.seatId = seatId;
        this.trainId = trainId;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public int getSeatId()
    {
        return seatId ;
    }
    public void setSeatId(int seatId)
    {
        this.seatId = seatId;
    }
    public int getTrainId()
    {
        return trainId;
    }
    public void setTrainId(int trainId)
    {
        this.trainId = trainId;
    }
    public int getSeatNumber ()
    {
        return seatNumber;
    }
    public void setSeatNumber(int seatNumber)
    {
        this.seatNumber = seatNumber;
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