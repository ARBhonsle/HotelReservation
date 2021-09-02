package com.bridgelabz.workshop;

import java.util.Scanner;

/**
 * Hotel Reservation Project
 */
public class HotelReservation {
    static Hotel hotel;

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation!");
        HotelService hotelService = new HotelService();
        hotel = new Hotel("Lakewood", 110.0, 90.0);
        hotelService.addHotel(hotel);
        hotel = new Hotel("Bridgewood", 160.0,60.0);
        hotelService.addHotel(hotel);
        hotel = new Hotel("Ridgewood",220.0,100.0);
        hotelService.addHotel(hotel);
    }
}
