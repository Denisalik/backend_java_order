package com.example.back.service;

import com.example.back.dto.ClientResponse;
import com.example.back.entity.Client;
import com.example.back.repo.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ClientResponse> getAllClients(){
        List<Client> clientsList = clientRepository.findAll();
        List<ClientResponse> clientResponseList = new ArrayList<>();
        for (Client client : clientsList){
            ClientResponse clientResponse = modelMapper.map(client, ClientResponse.class);
            clientResponseList.add(clientResponse);
        }
        return clientResponseList;
    }

    public ClientResponse getClient(long id) throws Exception{
        Client client = clientRepository.findById(id).orElseThrow(()->{return new Exception("cannot find by this id");});
        return modelMapper.map(client, ClientResponse.class);
    };
    public void postClient(ClientResponse clientResponse){
        Client client = modelMapper.map(clientResponse, Client.class);
        clientRepository.save(client);
    };
    public void addClient(Client client){
        clientRepository.save(client);
    };
}
