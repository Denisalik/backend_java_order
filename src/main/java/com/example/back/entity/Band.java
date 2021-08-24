package com.example.back.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Bands")
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long band_id;

    @Column(name="name_of_band")
    private String name_of_band;

    @Column(name="number_of_people")
    private int number_of_people;

    @Column(name="genre_of_music")
    private String genre_of_music;

    @OneToMany(mappedBy = "band", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Concert> concerts;

    public Band(){}
    public Band(String name_of_band, int number_of_people, String genre_of_music){
        this.name_of_band = name_of_band;
        this.number_of_people = number_of_people;
        this.genre_of_music = genre_of_music;
    }
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

    public Set<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(Set<Concert> concerts) {
        this.concerts = concerts;
    }
}
