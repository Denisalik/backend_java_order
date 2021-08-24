package com.example.back.service;

import com.example.back.dto.BandResponse;
import com.example.back.entity.Band;
import com.example.back.repo.BandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BandService {

    @Autowired
    private BandRepository bandRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<BandResponse> getAllBands(){
        List<Band> bandList = bandRepository.findAll();
        List<BandResponse> bandResponseList = new ArrayList<>();
        for (Band band : bandList){
            BandResponse bandResponse = modelMapper.map(band, BandResponse.class);
            bandResponseList.add(bandResponse);
        }
        return bandResponseList;//modelMapper.map(bandResponseList, BandListResponse.class);
    }

    public BandResponse getBand(long id) throws Exception{
        Band band = bandRepository.findById(id).orElseThrow(()->{return new Exception("cannot find by this id");});
        return modelMapper.map(band, BandResponse.class);
    };
    public void postBand(BandResponse bandResponse){
        Band band = modelMapper.map(bandResponse, Band.class);
        bandRepository.save(band);
    };
    public void addBand(Band band){
        bandRepository.save(band);
    };
}
