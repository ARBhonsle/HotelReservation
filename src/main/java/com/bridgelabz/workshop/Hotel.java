package com.bridgelabz.workshop;

public class Hotel {
    String hotelName;
    Double regularWeekdayRate;
    Double regularWeekendRate;

    public Hotel(String hotelName, Double regularWeekdayRate, Double regularWeekendRate) {
        this.hotelName = hotelName;
        this.regularWeekdayRate = regularWeekdayRate;
        this.regularWeekendRate =regularWeekendRate;
    }

    public void setRegularWeekdayRate(Double regularWeekdayRate) {
        this.regularWeekdayRate = regularWeekdayRate;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public Double getRegularWeekdayRate() {
        return regularWeekdayRate;
    }
}
