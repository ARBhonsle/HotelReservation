package com.bridgelabz.workshop;

public class Hotel {
    HotelKey key;
    static Double hotelRegularWeekdayRates, hotelRegularWeekendRates;
    static Double hotelRewardWeekdayRates, hotelRewardWeekendRates;
    Integer starRating;

    public Hotel(HotelKey key, Double weekdayRate, Double weekendRate, Integer starRating) {
        this.key=key;
        if(key.getCustomerType() == "REGULAR"){
            this.hotelRegularWeekdayRates = weekdayRate;
            this.hotelRegularWeekendRates = weekendRate;
        } else if(key.getCustomerType() == "REWARD"){
            this.hotelRewardWeekdayRates = weekdayRate;
            this.hotelRewardWeekendRates = weekendRate;
        }
        this.starRating = starRating;
    }

    public void setHotelRegularWeekdayRates(Double hotelRegularWeekdayRates) {
        this.hotelRegularWeekdayRates = hotelRegularWeekdayRates;
    }

    public void setHotelRegularWeekendRates(Double hotelRegularWeekendRates) {
        this.hotelRegularWeekendRates = hotelRegularWeekendRates;
    }

    public void setHotelRewardWeekdayRates(Double hotelRewardWeekdayRates) {
        this.hotelRewardWeekdayRates = hotelRewardWeekdayRates;
    }

    public void setHotelRewardWeekendRates(Double hotelRewardWeekendRates) {
        this.hotelRewardWeekendRates = hotelRewardWeekendRates;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }

    public HotelKey getKey() {
        return key;
    }

    public String getHotelName() {
        return key.getHotelName();
    }

    public String getCustomerType() {
        return key.getCustomerType();
    }

    public Double getHotelRegularWeekdayRates() {
        return hotelRegularWeekdayRates;
    }

    public Double getHotelRegularWeekendRates() {
        return hotelRegularWeekendRates;
    }

    public Double getHotelRewardWeekdayRates() {
        return hotelRewardWeekdayRates;
    }

    public Double getHotelRewardWeekendRates() {
        return hotelRewardWeekendRates;
    }

    public Integer getStarRating() {
        return starRating;
    }
}