package com.example.back.service;

import com.example.back.dto.ConcertResponse;
import com.example.back.entity.Concert;
import com.example.back.repo.ConcertRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConcertService {
    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ConcertResponse> getAllConcerts(){
        List<Concert> concertList = concertRepository.findAll();
        List<ConcertResponse> concertResponses = new ArrayList<>();
        for (Concert concert : concertList){
            ConcertResponse concertResponse = modelMapper.map(concert, ConcertResponse.class);
            concertResponses.add(concertResponse);
        }
        return concertResponses;
    }

    public ConcertResponse getConcert(long id) throws Exception{
        Concert concert = concertRepository.findById(id).orElseThrow(()->{return new Exception("cannot find by this id");});
        return modelMapper.map(concert, ConcertResponse.class);
    };
    public void postConcert(ConcertResponse concertResponse){
        Concert concert = modelMapper.map(concertResponse, Concert.class);
        concertRepository.save(concert);
    };
    public void addConcert(Concert concert){
        concertRepository.save(concert);
    };
}
