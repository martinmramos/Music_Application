package com.example.MusicApplication.services;

import com.example.MusicApplication.controllers.DTO.SongInputDTO;
import com.example.MusicApplication.controllers.personalExceptions.SongExistsException;
import com.example.MusicApplication.controllers.personalExceptions.SongNotFoundException;
import com.example.MusicApplication.domain.Song;
import com.example.MusicApplication.repositories.ArtistRepository;
import com.example.MusicApplication.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService {

    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private SongRepository songRepository;

    public void addSong(SongInputDTO songInputDTO) throws SongExistsException {
        if (songRepository.existsById(songInputDTO.getId())) throw new SongExistsException("Song already exist.");
        songRepository.save(songInputDTO.toDomain());
    }

    public void makeFavouriteSong(int id) throws SongNotFoundException {
        if (!songRepository.existsById(id)) throw new SongNotFoundException("Song doesn´t exist.");
        Optional<Song> song = songRepository.findById(id);
        if (song.get().isFavourite() == false) {
            song.get().setFavourite(true);
        } else song.get().setFavourite(false);
        songRepository.save(song.get());
    }
}
