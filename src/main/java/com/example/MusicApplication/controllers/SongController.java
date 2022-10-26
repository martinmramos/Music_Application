package com.example.MusicApplication.controllers;

import com.example.MusicApplication.controllers.DTO.SongInputDTO;
import com.example.MusicApplication.controllers.personalExceptions.SongExistsException;
import com.example.MusicApplication.controllers.personalExceptions.SongNotFoundException;
import com.example.MusicApplication.domain.Song;
import com.example.MusicApplication.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SongController {

    @Autowired
    private SongService songService;

    @PostMapping("/songs")
    public ResponseEntity<String> addSong(@RequestBody SongInputDTO songInputDTO) {
        try {
            songService.addSong(songInputDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (SongExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/songs/{songId}")
    public ResponseEntity<String> makeFavouriteSong(@PathVariable int songId) {
        try {
            songService.makeFavouriteSong(songId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (SongNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
