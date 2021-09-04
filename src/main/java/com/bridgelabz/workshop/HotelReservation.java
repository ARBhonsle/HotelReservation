package com.bridgelabz.workshop;

import java.util.Scanner;

/**
 * Hotel Reservation Project
 */
public class HotelReservation {
    static Hotel hotel;

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Hotel Reservation!");
        HotelService hotelService = new HotelService();
        hotel = new Hotel("Lakewood","REGULAR", 110.0,90.0);
        hotelService.addHotel(hotel.getHotelName(),hotel);
        hotel = new Hotel("Bridgewood", "REGULAR",150.0,50.0);
        hotelService.addHotel(hotel.getHotelName(),hotel);
        hotel = new Hotel("Ridgewood","REGULAR",220.0,150.0);
        hotelService.addHotel(hotel.getHotelName(),hotel);
    }

}