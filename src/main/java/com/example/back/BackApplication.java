package com.example.back;
import com.example.back.entity.Band;
import com.example.back.entity.Client;
import com.example.back.entity.Concert;
import com.example.back.entity.Order;
import com.example.back.service.BandService;
import com.example.back.service.ClientService;
import com.example.back.service.ConcertService;
import com.example.back.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication

public class BackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BandService bandService, ClientService clientService, OrderService orderService, ConcertService concertService){
        return args->{
            Band band1 = new Band("Rammstein", 6,"metal");
            Concert concert1 = new Concert(new Date(System.currentTimeMillis()), 225000, band1);
            Client client1 = new Client("Vasya","88005553535", "Moskva");
            Order order1 = new Order("Moscow", false, client1, concert1);
            bandService.addBand(band1);
            concertService.addConcert(concert1);
            clientService.addClient(client1);
            orderService.addOrder(order1);
        };
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
