package com.bridgelabz.workshop;

import org.junit.Test;

import javax.xml.crypto.Data;

import java.text.ParseException;

import static org.junit.Assert.*;

/**
 * Unit test for Hotel Reservation services.
 */
public class HotelReservationTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void checkHotelDetails() throws Exception {
        HotelService hotelService = new HotelService();
        Hotel hotel1 = new Hotel("Lakewood","REGULAR", 110.0);
        hotelService.addHotel(hotel1.getHotelName(), hotel1);
        Hotel hotel2 = new Hotel("Bridgewood", "REGULAR",160.0);
        hotelService.addHotel(hotel2.getHotelName(), hotel2);
        Hotel hotel3 = new Hotel("Ridgewood","REGULAR",  220.0);
        hotelService.addHotel(hotel3.getHotelName(), hotel3);
        hotelService.display();
        assertEquals(hotelService.getHotel(hotel1.getHotelName()), hotel1);
        assertEquals(hotelService.getHotel(hotel2.getHotelName()), hotel2);
        assertEquals(hotelService.getHotel(hotel3.getHotelName()), hotel3);
    }
    @Test
    public void findCheapestHotel_usingGivenDates() throws Exception {
        HotelService hotelService =new HotelService();
        hotelService.addHotel("Lakewood",new Hotel("Lakewood","REGULAR", 110.0));
        hotelService.addHotel("Bridgewood",new Hotel("Bridgewood", "REGULAR",160.0));
        hotelService.addHotel("Ridgewood",new Hotel("Ridgewood","REGULAR",  220.0));
        hotelService.display();
        String hotel = hotelService.getCheapestHotel(hotelService.getDayFromDate("2020-09-10"));
        System.out.println("Cheapest Hotel for 10/09/2020 : "+hotel);
        assertEquals(hotel,"Lakewood");
        hotel = hotelService.getCheapestHotel(hotelService.getDayFromDate("2020-09-11"));
        System.out.println("Cheapest Hotel for 10/09/2020 : "+hotel);
        assertEquals(hotel,"Lakewood");
        double totalAmount = hotelService.cheapestForGivenDateRange("2020-09-10","2020-09-11");
        assertEquals(totalAmount==220.0,true);
    }

}
