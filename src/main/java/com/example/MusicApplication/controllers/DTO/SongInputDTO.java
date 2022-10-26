package com.example.MusicApplication.controllers.DTO;

import com.example.MusicApplication.domain.Song;
import jdk.jfr.BooleanFlag;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class SongInputDTO {
    @Positive(message = "ID is negative.")
    private int id;
    @NotBlank(message = "Title is empty.")
    @NotNull(message = "Title is null.")
    private String title;
    @Positive(message = "Artist ID is negative.")
    private int artistId;
    @BooleanFlag
    private boolean favourite;

    public SongInputDTO(int id, String title, int artistId) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
        this.favourite = false;
    }

    public SongInputDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public Song toDomain(){
        return new Song(this.id, this.title, this.artistId);
    }
}
