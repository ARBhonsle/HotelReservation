package com.bridgelabz.workshop;

public class Hotel {
    String hotelName, customerType;
    Double hotelWeekdayRates, hotelWeekendRates;
    Integer starRating;

    public Hotel(String hotelName, String type, Double weekdayRate, Double weekendRate, Integer starRating) {
        this.hotelName = hotelName;
        this.customerType = type;
        this.hotelWeekdayRates = weekdayRate;
        this.hotelWeekendRates = weekendRate;
        this.starRating = starRating;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public void setHotelWeekdayRates(Double hotelWeekdayRates) {
        this.hotelWeekdayRates = hotelWeekdayRates;
    }

    public void setHotelWeekendRates(Double hotelWeekendRates) {
        this.hotelWeekendRates = hotelWeekendRates;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public Double getHotelWeekdayRates() {
        return hotelWeekdayRates;
    }

    public Double getHotelWeekendRates() {
        return hotelWeekendRates;
    }

    public Integer getStarRating() {
        return starRating;
    }
}