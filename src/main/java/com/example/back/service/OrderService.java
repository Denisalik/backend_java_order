package com.example.back.service;

import com.example.back.entity.Band;
import com.example.back.entity.Order;
import com.example.back.repo.BandRepository;
import com.example.back.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrder(long id) throws Exception{
        return orderRepository.findById(id).orElseThrow(()->{return new Exception("cannot find by this id");});
    };
    public void postOrder(Order order){
        orderRepository.save(order);
    };
}
