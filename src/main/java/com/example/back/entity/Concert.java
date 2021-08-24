package com.example.back.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Concerts")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long concert_id;

    @Column(name="time")
    private Date time;

    @Column(name="number_of_customers")
    private int number_of_customers;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="band_id")
    private Band band;

    @OneToMany(mappedBy = "concert", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Order> orders;

    public Concert() {}

    public Concert(Date time, int number_of_customers, Band band) {
        this.time = time;
        this.number_of_customers = number_of_customers;
        this.band = band;
    }

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

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
