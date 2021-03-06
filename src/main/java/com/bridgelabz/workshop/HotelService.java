package com.bridgelabz.workshop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class HotelService {
    private Map<HotelKey, Hotel> hotelDetails;
    private static HotelKey key;

    public HotelService() {
        hotelDetails = new LinkedHashMap<>();
    }

    // add hotel to list
    public void addHotel(HotelKey key, Hotel hotel) throws Exception {
        if (validateDetails(key)) {
            hotelDetails.put(key, hotel);
        }
    }

    public Collection<Hotel> getHotelList() {
        return hotelDetails.values();
    }

    //validate entered details
    private boolean validateDetails(HotelKey key) throws Exception {
        if (hotelDetails.get(key) == null) {
            return true;
        }
        if (hotelDetails.get(key).getHotelName() == key.getHotelName() && hotelDetails.get(key).getCustomerType() == key.getCustomerType()) {
            throw new Exception("Hotel already exist for this type of customer");
        }
        return false;
    }

    // find the cheapest hotel for given day
    public HotelKey getCheapestBestRatedHotel(int day, boolean isRegular) {
        Double minRates = Double.MAX_VALUE, hotelRate = null;
        boolean isWeekDay;
        if (day > 0 && day < 6) {
            System.out.println("Weekday");
            isWeekDay = true;
        } else {
            System.out.println("Weekend");
            isWeekDay = false;
        }
        for (HotelKey hotelKey : hotelDetails.keySet()) {
            if (isWeekDay) {
                if (isRegular) {
                    hotelRate = hotelDetails.get(hotelKey).getHotelRegularWeekdayRates();
                } else {
                    hotelRate = hotelDetails.get(hotelKey).getHotelRewardWeekdayRates();
                }
            } else {
                if (isRegular) {
                    hotelRate = hotelDetails.get(hotelKey).getHotelRegularWeekendRates();
                } else {
                    hotelRate = hotelDetails.get(hotelKey).getHotelRewardWeekendRates();
                }
            }
            if (minRates > hotelRate) {
                minRates = hotelRate;
                key = hotelKey;
            } else if (minRates.equals(hotelRate)) {
                if (hotelDetails.get(hotelKey).getStarRating() > hotelDetails.get(key).getStarRating()) {
                    key = hotelKey;
                }
            }
        }
        return key;
    }

    // returns hotel value using hotelName key
    public Hotel getHotel(HotelKey key) {
        return hotelDetails.get(key);
    }

    // display hotel object
    public String display() {
        StringBuilder displayHotel = new StringBuilder();
        for (HotelKey key : hotelDetails.keySet()) {
            displayHotel.append("Hotel: ").append(getHotel(key));
        }
        return displayHotel.toString();
    }

    // convert given date to day of week
    public int getDayFromDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int day = simpleDateFormat.parse(date).getDay();
        return day;
    }

    // cheapest hotel total price for given date range
    public double cheapestBestRatedHotelForGivenDateRange(String fromDate, String toDate, boolean isRegular) throws ParseException {
        LocalDate dateStart = LocalDate.parse(fromDate);
        LocalDate dateEnd = LocalDate.parse(toDate);
        double sum = 0;
        long noOfDays = ChronoUnit.DAYS.between(dateStart, dateEnd) + 1;
        int day = getDayFromDate(dateStart.toString());
        for (int i = 0; i < noOfDays; i++) {
            if (day > 0 && day < 6) {
                if (isRegular) {
                    sum += hotelDetails.get(getCheapestBestRatedHotel(day, isRegular)).getHotelRegularWeekdayRates();
                } else {
                    sum += hotelDetails.get(getCheapestBestRatedHotel(day, isRegular)).getHotelRewardWeekdayRates();
                }
            } else {
                if (isRegular) {
                    sum += hotelDetails.get(getCheapestBestRatedHotel(day, isRegular)).getHotelRegularWeekendRates();
                } else {
                    sum += hotelDetails.get(getCheapestBestRatedHotel(day, isRegular)).getHotelRewardWeekendRates();
                }
            }
            if (day == 6) {
                day = 0;
            } else {
                day++;
            }
        }
        return sum;
    }

    // returns star rating of hotel
    public Integer starRating(HotelKey key) {
        return hotelDetails.get(key).getStarRating();
    }

    // find Best Rated Hotel
    // find the cheapest hotel for given day
    public HotelKey getBestRatedHotel() {
        Integer starRate = -1;
        key = null;
        for (Hotel hotel : hotelDetails.values()) {
            if (hotel.getStarRating() > starRate) {
                starRate = hotel.getStarRating();
                key = hotel.getKey();
            }
        }
        return key;
    }

    // find total amount for date range for best rated hotel
    public double findBestRatedHotel(String startDate, String endDate) throws ParseException {
        LocalDate dateStart = LocalDate.parse(startDate);
        LocalDate dateEnd = LocalDate.parse(endDate);
        long noOfDays = ChronoUnit.DAYS.between(dateStart, dateEnd) + 1;
        double sum = 0;
        int day = getDayFromDate(dateStart.toString());
        for (int i = 0; i < noOfDays; i++) {
            if (day > 0 && day < 6) {
                sum += hotelDetails.get(getBestRatedHotel()).getHotelRegularWeekdayRates();
            } else {
                sum += hotelDetails.get(getBestRatedHotel()).getHotelRegularWeekendRates();
            }
            if (day == 6) {
                day = 0;
            } else {
                day++;
            }
        }
        return sum;
    }
}