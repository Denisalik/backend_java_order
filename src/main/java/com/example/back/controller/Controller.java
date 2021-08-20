package com.example.back.controller;

import com.example.back.entity.Band;
import com.example.back.entity.Client;
import com.example.back.entity.Concert;
import com.example.back.entity.Order;
import com.example.back.service.BandService;
import com.example.back.service.ClientService;
import com.example.back.service.ConcertService;
import com.example.back.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class Controller {

    @Autowired
    BandService bandService;

    @Autowired
    ClientService clientService;

    @Autowired
    OrderService orderService;

    @Autowired
    ConcertService concertService;

    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }
    @GetMapping("/client/{id}")
    public Client getClient(@PathVariable long id) throws Exception{
        return clientService.getClient(id);
    }
    @PostMapping("/client")
    public void postClient(@RequestBody Client client){
        clientService.postClient(client);
    }
    @GetMapping("/bands")
    public List<Band> getAllBands(){
        return bandService.getAllBands();
    }
    @GetMapping("/band/{id}")
    public Band getBand(@PathVariable long id) throws Exception{
        return bandService.getBand(id);
    }
    @PostMapping("/band")
    public void postBand(@RequestBody Band band){
        bandService.postBand(band);
    }
    @GetMapping("/concerts")
    public List<Concert> getAllConcerts(){
        return concertService.getAllConcerts();
    }
    @GetMapping("/concert/{id}")
    public Concert getConcert(@PathVariable long id) throws Exception{
        return concertService.getConcert(id);
    }
    @PostMapping("/concert")
    public void postConcert(@RequestBody Concert concert){
        concertService.postConcert(concert);
    }
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable long id) throws Exception{
        return orderService.getOrder(id);
    }
    @PostMapping("/order")
    public void postOrder(@RequestBody Order order){
        orderService.postOrder(order);
    }
}
