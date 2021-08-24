package com.example.back.dto;

import java.io.Serializable;

public class BandResponse implements Serializable {
    public Long band_id;
    public String name_of_band;
    public int number_of_people;
    public String genre_of_music;

    public Long getBand_id() {
        return band_id;
    }

    public void setBand_id(Long band_id) {
        this.band_id = band_id;
    }

    public String getName_of_band() {
        return name_of_band;
    }

    public void setName_of_band(String name_of_band) {
        this.name_of_band = name_of_band;
    }

    public int getNumber_of_people() {
        return number_of_people;
    }

    public void setNumber_of_people(int number_of_people) {
        this.number_of_people = number_of_people;
    }

    public String getGenre_of_music() {
        return genre_of_music;
    }

    public void setGenre_of_music(String genre_of_music) {
        this.genre_of_music = genre_of_music;
    }
}
