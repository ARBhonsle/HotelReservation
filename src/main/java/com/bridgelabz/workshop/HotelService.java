package com.bridgelabz.workshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class HotelService {
    private Hashtable<String,Hotel> hotelDetails;

    public HotelService(){
        hotelDetails = new Hashtable<>();
    }

    public void addHotel(String hotelName, Hotel hotel){
        hotelDetails.put(hotelName,hotel);
    }

    public Hotel getHotel(String hotelName){
        return hotelDetails.get(hotelName);
    }

    public String display(){
        StringBuilder displayHotel = new StringBuilder();
        for(String hotelName: hotelDetails.keySet()){
            displayHotel.append("Hotel Name: ").append(getHotel(hotelName));
        }
        return displayHotel.toString();
    }
}
