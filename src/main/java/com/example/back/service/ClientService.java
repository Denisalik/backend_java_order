package com.example.back.service;

import com.example.back.entity.Client;
import com.example.back.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClient(long id) throws Exception{
        return clientRepository.findById(id).orElseThrow(()->{return new Exception("cannot find by this id");});
    };
    public void postClient(Client client){
        clientRepository.save(client);
    };
}
