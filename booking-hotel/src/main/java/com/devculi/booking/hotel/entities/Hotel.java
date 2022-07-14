package com.devculi.booking.hotel.entities;

public class Hotel
{
    private Integer Id;
    private String name;
    private String location;

    public Hotel(Integer id, String name, String location)
    {
        super();
        Id = id;
        this.name = name;
        this.location = location;
    }

    public Integer getId()
    {
        return Id;
    }

    public void setId(Integer id)
    {
        Id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

}
