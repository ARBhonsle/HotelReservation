package com.bridgelabz.workshop;

import java.util.ArrayList;

public class HotelService {
    ArrayList<Hotel> hotelList;

    public HotelService(){
        hotelList = new ArrayList<>();
    }

    public void addHotel(Hotel hotel){
        hotelList.add(hotel);
    }
    public Hotel getHotel(int index){
        return hotelList.get(index);
    }
    public void display(){
        for(int index = 0;index<hotelList.size();index++){
            System.out.println("Hotel Name: "+hotelList.get(index).hotelName);
            System.out.println("Hotel Regular Weekday Rate: "+hotelList.get(index).regularWeekdayRate);
            System.out.println("Hotel Regular Weekend Rate: "+hotelList.get(index).regularWeekendRate);
        }
    }
}
