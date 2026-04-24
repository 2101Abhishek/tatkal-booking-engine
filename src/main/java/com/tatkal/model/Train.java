package com.tatkal.model;
public class Train
{
    private int trainId;
    private String name;
    private int totalSeats;
    private String boarding;
    private String destination;

    public Train(int trainId,String name,int totalSeats,
        String boarding, String destination)
    {
        this.trainId = trainId;
        this.name = name;
        this.totalSeats = totalSeats;
        this.boarding = boarding;
        this.destination = destination;
    }

    public int getTrainId()
    {
        return trainId;
    }
    public void setTrainId(int trainId)
    {
        this.trainId = trainId;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name= name;
    }
    public int getTotalSeats()
    {
        return totalSeats;
    }
    public void setTotalSeats(int totalSeats)
    {
        this.totalSeats = totalSeats;
    }
    public String getBoarding()
    {
        return boarding;
    }
    public void setBoarding(String boarding)
    {
        this.boarding = boarding;
    }
    public String getDestination()
    {
        return destination;
    }
    public void setDestination(String destination)
    {
        this.destination = destination;
    }
}