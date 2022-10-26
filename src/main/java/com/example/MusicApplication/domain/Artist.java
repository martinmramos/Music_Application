package com.example.MusicApplication.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity(name = "artists")
public class Artist {

    @Id
    @Positive(message = "ID is negative.")
    private int id;
    @NotNull(message = "Name is null.")
    @NotBlank(message = "Name is empty.")
    private String name;

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist() {
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
}
