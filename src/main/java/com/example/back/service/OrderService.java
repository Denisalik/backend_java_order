package com.example.back.service;

import com.example.back.dto.OrderResponse;
import com.example.back.entity.Client;
import com.example.back.entity.Concert;
import com.example.back.entity.Order;
import com.example.back.repo.ClientRepository;
import com.example.back.repo.ConcertRepository;
import com.example.back.repo.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<OrderResponse> getAllOrders(){
        List<Order> orderList = orderRepository.findAll();
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (Order order : orderList){
            OrderResponse orderResponse = modelMapper.map(order, OrderResponse.class);
            orderResponseList.add(orderResponse);
        }
        return orderResponseList;
    }

    public OrderResponse getOrder(long id) throws Exception{
        Order order = orderRepository.findById(id).orElseThrow(()->{return new Exception("cannot find by this id");});
        return modelMapper.map(order, OrderResponse.class);
    };
    public void postOrder(OrderResponse orderResponse, long concert_id, long client_id) throws Exception {
        Concert concert = concertRepository.findById(concert_id).orElseThrow(()->{return new Exception("cannot find by this concert id");});
        Client client = clientRepository.findById(client_id).orElseThrow(()->{return new Exception("cannot find by this client id");});
        Order order = modelMapper.map(orderResponse, Order.class);
        order.setClient(client);
        order.setConcert(concert);
        orderRepository.save(order);
    };
    public void addOrder(Order order){
        orderRepository.save(order);
    };
}
