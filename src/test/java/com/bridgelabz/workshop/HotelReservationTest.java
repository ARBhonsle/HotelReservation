package com.bridgelabz.workshop;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple HotelReservation.
 */
public class HotelReservationTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void checkHotelDetails()
    {
        HotelService hotelService = new HotelService();
        Hotel hotel1 = new Hotel("Lakewood", 110.0, 90.0);
        hotelService.addHotel(hotel1);
        Hotel hotel2 = new Hotel("Bridgewood", 160.0,60.0);
        hotelService.addHotel(hotel2);
        Hotel hotel3 = new Hotel("Ridgewood",220.0,100.0);
        hotelService.addHotel(hotel3);
        hotelService.display();
        assertEquals(hotelService.hotelList.get(0),hotel1);
        assertEquals(hotelService.hotelList.get(1),hotel2);
        assertEquals(hotelService.hotelList.get(2),hotel3);
    }
}
