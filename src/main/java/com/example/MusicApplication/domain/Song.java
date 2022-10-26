package com.example.MusicApplication.domain;

import jdk.jfr.BooleanFlag;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity(name = "songs")
public class Song {

    @Id
    @Positive(message = "ID is negative.")
    private int id;
    @NotBlank(message = "Title is empty.")
    @NotNull(message = "Title is null.")
    private String title;
    @Positive(message = "Artist ID is negative.")
    private int artistId;
    @BooleanFlag
    private boolean favourite;

    public Song(int id, String title, int artistId) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
        this.favourite = false;
    }

    public Song() {
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
}
