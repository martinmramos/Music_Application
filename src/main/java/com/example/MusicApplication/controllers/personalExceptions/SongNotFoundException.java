package com.example.MusicApplication.controllers.personalExceptions;

public class SongNotFoundException extends Exception{
    public SongNotFoundException(String message) {
        super(message);
    }
}
