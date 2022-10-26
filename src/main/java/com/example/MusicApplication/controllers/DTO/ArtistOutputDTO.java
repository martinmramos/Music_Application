package com.example.MusicApplication.controllers.DTO;

import com.example.MusicApplication.domain.Artist;
import com.example.MusicApplication.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ArtistOutputDTO {
    @Positive(message = "ID is negative.")
    private int id;
    @NotNull(message = "Name is null.")
    @NotBlank(message = "Name is empty.")
    private String name;
    private SongOutputDTO[] songs;

    @Autowired
    private SongRepository songRepository;

    public ArtistOutputDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArtistOutputDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SongOutputDTO[] getSongs() {
        return songs;
    }

    public void setSongs(SongOutputDTO[] songs) {
        this.songs = songs;
    }

    public static ArtistOutputDTO fromDomain(Artist artist){
        return new ArtistOutputDTO(artist.getId(), artist.getName());
    }
}
