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
        if(validateDetails(hotelName, hotel.getCustomerType())){
            hotelDetails.put(hotelName, hotel);
        }
    }
    //validate entered details
    private boolean validateDetails(String hotelName, String customerType) throws Exception {
        if( hotelDetails.get(hotelName)== null ){
            return true;
        }
        if (hotelDetails.get(hotelName).getHotelName() == hotelName && hotelDetails.get(hotelName).getCustomerType() == customerType) {
            throw new Exception("Hotel already exist for this type of customer");
        }
        return false;
    }
    // find the cheapest hotel for given day
    public String getCheapestHotel(int day) {
        StringBuilder hotelName= new StringBuilder();
        Double minRates = Double.MAX_VALUE, hotelRate;
        boolean isWeekDay;
        if (day > 0 && day < 6) {
            System.out.println("Weekday");
            isWeekDay=true;
        } else {
            System.out.println("Weekend");
            isWeekDay=false;
        }
        for (Hotel hotel : hotelDetails.values()) {
            if(isWeekDay){
                hotelRate = hotel.getHotelWeekdayRates();
            }else{
                hotelRate = hotel.getHotelWeekendRates();
            }
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int day = simpleDateFormat.parse(date).getDay();
        return day;
    }
    // cheapest hotel total price for given date range
    public double cheapestForGivenDateRange(String fromDate, String toDate) throws ParseException {
        LocalDate dateStart = LocalDate.parse(fromDate);
        LocalDate dateEnd = LocalDate.parse(toDate);
        long noOfDays = ChronoUnit.DAYS.between(dateStart, dateEnd) + 1;
        int day = getDayFromDate(dateStart.toString());
        double sum;
        if(day>0 && day<6){
            sum = hotelDetails.get(getCheapestHotel(day)).getHotelWeekdayRates();
        } else{
            sum = hotelDetails.get(getCheapestHotel(day)).getHotelWeekendRates();
        }
        return noOfDays*sum;
    }
}
