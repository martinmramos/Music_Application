package com.example.MusicApplication.controllers.personalExceptions;

public class ArtistExistsException extends Exception{
    public ArtistExistsException(String message) {
        super(message);
    }
}
