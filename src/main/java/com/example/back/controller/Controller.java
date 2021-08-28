package com.example.back.controller;

import com.example.back.dto.*;
import com.example.back.service.BandService;
import com.example.back.service.ClientService;
import com.example.back.service.ConcertService;
import com.example.back.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
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
    public List<ClientResponse> getAllClients(){
        return clientService.getAllClients();
    }
    @GetMapping("/client/{id}")
    public ClientResponse getClient(@PathVariable long id) throws Exception{
        return clientService.getClient(id);
    }
    @PostMapping("/client")
    public void postClient(@RequestBody ClientResponse clientResponse){
        clientService.postClient(clientResponse);
    }
    @GetMapping("/bands")
    public List<BandResponse> getAllBands(){
        return bandService.getAllBands();
    }
    @GetMapping("/band/{id}")
    public BandResponse getBand(@PathVariable long id) throws Exception{
        return bandService.getBand(id);
    }
    @PostMapping("/band")
    public void postBand(@RequestBody BandResponse bandResponse){
        bandService.postBand(bandResponse);
    }
    @GetMapping("/concerts")
    public List<ConcertResponse> getAllConcerts(){
        return concertService.getAllConcerts();
    }
    @GetMapping("/concert/{id}")
    public ConcertResponse getConcert(@PathVariable long id) throws Exception{
        return concertService.getConcert(id);
    }
    @PostMapping("/concert")
    public void postConcert(@RequestBody ConcertResponse concertResponse){
        concertService.postConcert(concertResponse);
    }
    @GetMapping("/orders")
    public List<OrderResponse> getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping("/order/{id}")
    public OrderResponse getOrder(@PathVariable long id) throws Exception{
        return orderService.getOrder(id);
    }
    @PostMapping("/order")
    public void postOrder(@RequestBody OrderResponse orderResponse, @RequestParam long concert_id, @RequestParam long client_id) throws Exception {
        orderService.postOrder(orderResponse, concert_id, client_id);
    }
}
