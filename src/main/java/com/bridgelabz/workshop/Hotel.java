package com.bridgelabz.workshop;

public class Hotel {
    String hotelName, customerType;
    Double hotelWeekdayRates, hotelWeekendRates;

    public Hotel(String hotelName, String type, Double weekdayRate, Double weekendRate) {
        this.hotelName = hotelName;
        this.customerType = type;
        this.hotelWeekdayRates = weekdayRate;
        this.hotelWeekendRates = weekendRate;
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
}