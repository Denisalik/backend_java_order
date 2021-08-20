package com.example.back.service;

import com.example.back.entity.Concert;
import com.example.back.repo.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertService {
    @Autowired
    private ConcertRepository concertRepository;

    public List<Concert> getAllConcerts(){
        return concertRepository.findAll();
    }

    public Concert getConcert(long id) throws Exception{
        return concertRepository.findById(id).orElseThrow(()->{return new Exception("cannot find by this id");});
    };
    public void postConcert(Concert concert){
        concertRepository.save(concert);
    };
}
