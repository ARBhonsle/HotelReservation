package com.bridgelabz.workshop;

public class HotelKey {
    String hotelName, customerType;

    public HotelKey(String hotelName, String type){
        this.hotelName=hotelName;
        this.customerType=type;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCustomerType() {
        return customerType;
    }
}
