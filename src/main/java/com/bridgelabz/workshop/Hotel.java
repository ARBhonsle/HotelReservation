package com.bridgelabz.workshop;

public class Hotel {
    String hotelName, customerType;
    Double hotelRates;

    public Hotel(String hotelName, String type, Double hotelRates) {
        this.hotelName = hotelName;
        this.hotelRates = hotelRates;
        this.customerType=type;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setHotelRates(Double hotelRates) {
        this.hotelRates = hotelRates;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getHotelName() {
        return hotelName;
    }

    public Double getHotelRates() {
        return hotelRates;
    }

    public String getCustomerType() {
        return customerType;
    }
}
