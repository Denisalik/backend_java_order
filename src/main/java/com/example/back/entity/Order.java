package com.example.back.entity;

import javax.persistence.*;

@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @Column(name="place_of_purchase", nullable=false)
    private String place_of_purchase;

    @Column(name="vip_status", nullable = false)
    private boolean vip_status;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Concert concerts;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Concert getConcerts() {
        return concerts;
    }

    public void setConcerts(Concert concerts) {
        this.concerts = concerts;
    }
}
