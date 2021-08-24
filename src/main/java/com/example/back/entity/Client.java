package com.example.back.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;

    @Column(name="name")
    private String name;

    @Column(name="phone", length = 12)
    private String phone;

    @Column(name="address")
    private String address;

    @OneToMany(mappedBy = "client", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Order> orders;

    public Client(){}
    public Client(String name, String phone, String address){
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
