package com.bridgelabz.workshop;

import org.junit.Test;

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
        Hotel hotel1 = new Hotel(new HotelKey("Lakewood", "REGULAR"), 110.0, 90.0, 3);
        hotelService.addHotel(hotel1.getKey(), hotel1);
        Hotel hotel2 = new Hotel(new HotelKey("Bridgewood", "REGULAR"), 150.0, 50.0, 4);
        hotelService.addHotel(hotel2.getKey(), hotel2);
        Hotel hotel3 = new Hotel(new HotelKey("Ridgewood", "REGULAR"), 220.0, 150.0, 5);
        hotelService.addHotel(hotel3.getKey(), hotel3);
        hotelService.display();
        assertEquals(hotelService.getHotel(hotel1.getKey()), hotel1);
        assertEquals(hotelService.getHotel(hotel2.getKey()), hotel2);
        assertEquals(hotelService.getHotel(hotel3.getKey()), hotel3);
    }

    @Test
    public void findCheapestBestRatedHotel_usingGivenDates() throws Exception {
        HotelService hotelService = new HotelService();
        hotelService.addHotel(new HotelKey("Lakewood", "REGULAR"), new Hotel(new HotelKey("Lakewood", "REGULAR"), 110.0, 90.0, 3));
        hotelService.addHotel(new HotelKey("Bridgewood", "REGULAR"), new Hotel(new HotelKey("Bridgewood", "REGULAR"), 150.0, 50.0, 4));
        hotelService.addHotel(new HotelKey("Ridgewood", "REGULAR"), new Hotel(new HotelKey("Ridgewood", "REGULAR"), 220.0, 150.0, 5));
        hotelService.display();
        HotelKey hotelKey = hotelService.getCheapestBestRatedHotel(hotelService.getDayFromDate("2020-09-10"));
        System.out.println("Cheapest Hotel for 10/09/2020 : " + hotelKey);
        assertEquals(hotelKey, "Lakewood");
        hotelKey = hotelService.getCheapestBestRatedHotel(hotelService.getDayFromDate("2020-09-11"));
        System.out.println("Cheapest Hotel for 11/09/2020 : " + hotelKey);
        assertEquals(hotelKey.getHotelName(), "Lakewood");
        double totalAmount = hotelService.cheapestBestRatedHotelForGivenDateRange("2020-09-10", "2020-09-11");
        assertEquals(totalAmount == 220.0, true);
    }

    @Test
    public void addWeekdayAndWeekEnd_checksHotelDetails() throws Exception {
        HotelService hotelService = new HotelService();
        Hotel hotel1 = new Hotel(new HotelKey("Lakewood", "REGULAR"), 110.0, 90.0, 3);
        hotelService.addHotel(hotel1.getKey(), hotel1);
        Hotel hotel2 = new Hotel(new HotelKey("Bridgewood", "REGULAR"), 150.0, 50.0, 4);
        hotelService.addHotel(hotel2.getKey(), hotel2);
        Hotel hotel3 = new Hotel(new HotelKey("Ridgewood", "REGULAR"), 220.0, 150.0, 5);
        hotelService.addHotel(hotel3.getKey(), hotel3);
        hotelService.display();
        assertEquals(hotelService.getHotel(hotel1.getKey()), hotel1);
        assertEquals(hotelService.getHotel(hotel2.getKey()), hotel2);
        assertEquals(hotelService.getHotel(hotel3.getKey()), hotel3);
    }

    @Test
    public void findCheapestBestRatedHotel_afterWeekdayAndWeekend_usingGivenDates() throws Exception {
        HotelService hotelService = new HotelService();
        hotelService.addHotel(new HotelKey("Lakewood", "REGULAR"), new Hotel(new HotelKey("Lakewood", "REGULAR"), 110.0, 90.0, 3));
        hotelService.addHotel(new HotelKey("Bridgewood", "REGULAR"), new Hotel(new HotelKey("Bridgewood", "REGULAR"), 150.0, 50.0, 4));
        hotelService.addHotel(new HotelKey("Ridgewood", "REGULAR"), new Hotel(new HotelKey("Ridgewood", "REGULAR"), 220.0, 150.0, 5));
        HotelKey hotelKey = hotelService.getCheapestBestRatedHotel(hotelService.getDayFromDate("2020-09-11"));
        System.out.println("Cheapest Hotel for 11/09/2020 : " + hotelKey);
        assertEquals(hotelKey.getHotelName(), "Lakewood");
        hotelKey = hotelService.getCheapestBestRatedHotel(hotelService.getDayFromDate("2020-09-12"));
        System.out.println("Cheapest Hotel for 12/09/2020 : " + hotelKey);
        assertEquals(hotelKey.getHotelName(), "Bridgewood");
        double totalAmount = hotelService.cheapestBestRatedHotelForGivenDateRange("2020-09-11", "2020-09-12");
        assertEquals(totalAmount == 160.0, true);
    }

    @Test
    public void checkStarRating_returnsTrue() throws Exception {
        HotelService hotelService = new HotelService();
        hotelService.addHotel(new HotelKey("Lakewood", "REGULAR"), new Hotel(new HotelKey("Lakewood", "REGULAR"), 110.0, 90.0, 3));
        hotelService.addHotel(new HotelKey("Bridgewood", "REGULAR"), new Hotel(new HotelKey("Bridgewood", "REGULAR"), 150.0, 50.0, 4));
        hotelService.addHotel(new HotelKey("Ridgewood", "REGULAR"), new Hotel(new HotelKey("Ridgewood", "REGULAR"), 220.0, 150.0, 5));
        assertTrue(hotelService.starRating("Lakewood") == 3);
        assertTrue(hotelService.starRating("Bridgewood") == 4);
        assertTrue(hotelService.starRating("Ridgewood") == 5);
    }

    @Test
    public void findBestRatedHotel_returnsTotalAmount() throws Exception {
        HotelService hotelService = new HotelService();
        hotelService.addHotel(new HotelKey("Lakewood", "REGULAR"), new Hotel(new HotelKey("Lakewood", "REGULAR"), 110.0, 90.0, 3));
        hotelService.addHotel(new HotelKey("Bridgewood", "REGULAR"), new Hotel(new HotelKey("Bridgewood", "REGULAR"), 150.0, 50.0, 4));
        hotelService.addHotel(new HotelKey("Ridgewood", "REGULAR"), new Hotel(new HotelKey("Ridgewood", "REGULAR"), 220.0, 150.0, 5));
        HotelKey hotelKey = hotelService.getBestRatedHotel();
        System.out.println("Cheapest Hotel for 11/09/2020 : " + hotelKey);
        assertEquals(hotelKey.getHotelName(), "Ridgewood");
        hotelKey = hotelService.getBestRatedHotel();
        System.out.println("Cheapest Hotel for 12/09/2020 : " + hotelKey);
        assertEquals(hotelKey.getHotelName(), "Ridgewood");
        assertTrue(hotelService.findBestRatedHotel("2020-09-11", "2020-09-12") == 370);
    }

    @Test
    public void addedSpecialHotelRates_forRewardCustomers() throws Exception {
        HotelService hotelService = new HotelService();

        HotelKey hotelKey1= new HotelKey("Lakewood", "REGULAR");
        Hotel hotel1 =new Hotel(hotelKey1, 110.0, 90.0, 3);
        hotelService.addHotel(hotelKey1,hotel1);
        HotelKey hotelKey2 = new HotelKey("Bridgewood", "REGULAR");
        Hotel hotel2 = new Hotel(hotelKey2, 150.0, 50.0, 4);
        hotelService.addHotel(hotelKey2,hotel2);
        HotelKey hotelKey3 = new HotelKey("Ridgewood", "REGULAR");
        Hotel hotel3 = new Hotel(hotelKey3, 220.0, 150.0, 5);
        hotelService.addHotel(hotelKey3, hotel3);

        HotelKey hotelKey4 = new HotelKey("Lakewood", "REWARD");
        Hotel hotel4 = new Hotel(hotelKey4, 80.0, 80.0, 3);
        hotelService.addHotel(hotelKey4, hotel4);
        HotelKey hotelKey5 = new HotelKey("Bridgewood", "REWARD");
        Hotel hotel5 = new Hotel(hotelKey5, 110.0, 50.0, 4);
        hotelService.addHotel(hotelKey5, hotel5);
        HotelKey hotelKey6 = new HotelKey("Ridgewood", "REWARD");
        Hotel hotel6 = new Hotel(hotelKey6, 100.0, 40.0, 5);
        hotelService.addHotel(hotelKey6, hotel6);

        assertEquals(hotelService.getHotel(hotelKey1),hotel1);
        assertEquals(hotelService.getHotel(hotelKey2),hotel2);
        assertEquals(hotelService.getHotel(hotelKey3),hotel3);
        assertEquals(hotelService.getHotel(hotelKey4),hotel4);
        assertEquals(hotelService.getHotel(hotelKey5),hotel5);
        assertEquals(hotelService.getHotel(hotelKey6),hotel6);
    }
}