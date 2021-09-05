package com.bridgelabz.workshop;

/**
 * Hotel Reservation Project
 */
public class HotelReservation {
    static Hotel hotel;

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Hotel Reservation!");
        HotelService hotelService = new HotelService();
        hotel = new Hotel(new HotelKey("Lakewood", "REGULAR"), 110.0, 90.0, 3);
        hotelService.addHotel(hotel.getKey(), hotel);
        hotel = new Hotel(new HotelKey("Bridgewood", "REGULAR"), 150.0, 50.0, 4);
        hotelService.addHotel(hotel.getKey(), hotel);
        hotel = new Hotel(new HotelKey("Ridgewood", "REGULAR"), 220.0, 150.0, 5);
        hotelService.addHotel(hotel.getKey(), hotel);
    }

}