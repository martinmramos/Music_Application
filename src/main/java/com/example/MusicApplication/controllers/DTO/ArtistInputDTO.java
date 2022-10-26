package com.example.MusicApplication.controllers.DTO;

import com.example.MusicApplication.domain.Artist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ArtistInputDTO {

    @Positive(message = "ID is negative.")
    private int id;
    @NotNull(message = "Name is null.")
    @NotBlank(message = "Name is empty.")
    private String name;

    public ArtistInputDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArtistInputDTO() {
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

    public Artist toDomain(){
        return new Artist(this.id, this.name);
    }
}
