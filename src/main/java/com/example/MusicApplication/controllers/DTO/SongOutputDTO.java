package com.example.MusicApplication.controllers.DTO;

import com.example.MusicApplication.domain.Song;
import jdk.jfr.BooleanFlag;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SongOutputDTO {

    @NotBlank(message = "Title is empty.")
    @NotNull(message = "Title is null.")
    private String title;
    @BooleanFlag
    private boolean favourite;

    public SongOutputDTO(String title, boolean favourite) {
        this.title = title;
        this.favourite = favourite;
    }

    public SongOutputDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public static SongOutputDTO fromDomain(Song song){
        return new SongOutputDTO(song.getTitle(), song.isFavourite());
    }
}
