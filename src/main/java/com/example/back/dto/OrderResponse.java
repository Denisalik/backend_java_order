package com.example.back.dto;

import java.io.Serializable;

public class OrderResponse implements Serializable {
    public Long order_id;
    public String place_of_purchase;
    public boolean vip_status;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getPlace_of_purchase() {
        return place_of_purchase;
    }

    public void setPlace_of_purchase(String place_of_purchase) {
        this.place_of_purchase = place_of_purchase;
    }

    public boolean isVip_status() {
        return vip_status;
    }

    public void setVip_status(boolean vip_status) {
        this.vip_status = vip_status;
    }
}
