package com.example.back.service;

import com.example.back.entity.Band;
import com.example.back.repo.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {
    @Autowired
    private BandRepository bandRepository;

    public List<Band> getAllBands(){
        return bandRepository.findAll();
    }

    public Band getBand(long id) throws Exception{
        return bandRepository.findById(id).orElseThrow(()->{return new Exception("cannot find by this id");});
    };
    public void postBand(Band band){
        bandRepository.save(band);
    };
}
