package com.example.MusicApplication.controllers;


import com.example.MusicApplication.controllers.DTO.ArtistInputDTO;
import com.example.MusicApplication.controllers.DTO.ArtistOutputDTO;
import com.example.MusicApplication.controllers.personalExceptions.ArtistExistsException;
import com.example.MusicApplication.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping("/artists")
    public ResponseEntity<String> addArtist(@RequestBody ArtistInputDTO artistInputDTO) {
        try {
            artistService.addArtist(artistInputDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (ArtistExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/artists")
    public ResponseEntity<List<ArtistOutputDTO>> getAllArtists() {
        return ResponseEntity.ok(artistService.getAllArtistsWithSongs());
    }
}
