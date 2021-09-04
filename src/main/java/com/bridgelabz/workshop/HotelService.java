package com.bridgelabz.workshop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class HotelService {
    private Map<String, Hotel> hotelDetails;

    public HotelService() {
        hotelDetails = new LinkedHashMap<>();
    }

    // add hotel to list
    public void addHotel(String hotelName, Hotel hotel) throws Exception {
        if (validateDetails(hotelName, hotel.getCustomerType())) {
            hotelDetails.put(hotelName, hotel);
        }
    }

    // UC1 ....
    private boolean validateDetails(String hotelName, String customerType) throws Exception {
        if (hotelDetails.get(hotelName) == null) {
            return true;
        }
        if (hotelDetails.get(hotelName).getHotelName() == hotelName && hotelDetails.get(hotelName).getCustomerType() == customerType) {
            throw new Exception("Hotel already exist for this type of customer");
        }
        return false;
    }

    // find the cheapest hotel for given day
    public String getCheapestHotel(int day) {
        StringBuilder hotelName = new StringBuilder();
        Double minRates = Double.MAX_VALUE, hotelRate;
        if (day > 0 && day < 6) {
            System.out.println("Weekday");
        } else {
            System.out.println("Weekend");
        }
        for (Hotel hotel : hotelDetails.values()) {
            hotelRate = hotel.getHotelRates();
            if (minRates > hotelRate) {
                minRates = hotelRate;
                hotelName.append(hotel.getHotelName());
            }
        }
        return hotelName.toString();
    }

    public Hotel getHotel(String hotelName) {
        return hotelDetails.get(hotelName);
    }

    public String display() {
        StringBuilder displayHotel = new StringBuilder();
        for (String hotelName : hotelDetails.keySet()) {
            displayHotel.append("Hotel: ").append(getHotel(hotelName));
        }
        return displayHotel.toString();
    }

    // convert given date to day of week
    public int getDayFromDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int day = simpleDateFormat.parse(date).getDay();
        return day;
    }

    public double cheapestForGivenDateRange(String fromDate, String toDate) throws ParseException {
        LocalDate dateStart = LocalDate.parse(fromDate);
        LocalDate dateEnd = LocalDate.parse(toDate);
        long noOfDays = ChronoUnit.DAYS.between(dateStart, dateEnd) + 1;
        double totalSum = noOfDays * hotelDetails.get(getCheapestHotel(getDayFromDate(dateStart.toString()))).getHotelRates();
        return totalSum;
    }
}
