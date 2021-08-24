package com.example.back.dto;

import java.io.Serializable;
import java.util.Date;

public class ConcertResponse implements Serializable {
    public Long concert_id;
    public Date time;
    public int number_of_customers;

    public Long getConcert_id() {
        return concert_id;
    }

    public void setConcert_id(Long concert_id) {
        this.concert_id = concert_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getNumber_of_customers() {
        return number_of_customers;
    }

    public void setNumber_of_customers(int number_of_customers) {
        this.number_of_customers = number_of_customers;
    }
}
