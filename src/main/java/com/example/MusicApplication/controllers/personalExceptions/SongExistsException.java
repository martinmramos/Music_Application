package com.example.MusicApplication.controllers.personalExceptions;

public class SongExistsException extends Exception {
    public SongExistsException(String message) {
        super(message);
    }
}
