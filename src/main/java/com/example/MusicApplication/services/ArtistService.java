package com.example.MusicApplication.services;

import com.example.MusicApplication.controllers.DTO.ArtistOutputDTO;
import com.example.MusicApplication.controllers.DTO.SongOutputDTO;
import com.example.MusicApplication.controllers.personalExceptions.ArtistExistsException;
import com.example.MusicApplication.controllers.DTO.ArtistInputDTO;
import com.example.MusicApplication.domain.Artist;
import com.example.MusicApplication.domain.Song;
import com.example.MusicApplication.repositories.ArtistRepository;
import com.example.MusicApplication.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArtistService {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private ArtistRepository artistRepository;

    public void addArtist(ArtistInputDTO artistInput) throws ArtistExistsException {
        if (artistRepository.existsById(artistInput.getId())) throw new ArtistExistsException("Artist already exists.");
        artistRepository.save(artistInput.toDomain());
    }

    public ArrayList<ArtistOutputDTO> getAllArtists() {
        ArrayList<ArtistOutputDTO> allArtistsOutput = new ArrayList<>();
        for (Artist artist : artistRepository.findAll()) {
            allArtistsOutput.add(ArtistOutputDTO.fromDomain(artist));
        }
        return allArtistsOutput;
    }

    public ArrayList<SongOutputDTO> getAllSongsByArtist(int artistId) {
        ArrayList<SongOutputDTO> allSongByArtist = new ArrayList<>();
        for (Song song : songRepository.findByArtistId(artistId)) {
            allSongByArtist.add(SongOutputDTO.fromDomain(song));
        }
        return allSongByArtist;
    }

    public ArrayList<ArtistOutputDTO> getAllArtistsWithSongs() {
        ArrayList<ArtistOutputDTO> allArtistsWithSongs = new ArrayList<>();
        for (ArtistOutputDTO artistOutputDTO : getAllArtists()) {
            ArrayList<SongOutputDTO> allSongsByArtist = new ArrayList<>(getAllSongsByArtist(artistOutputDTO.getId()));
            artistOutputDTO.setSongs(allSongsByArtist.toArray(new SongOutputDTO[allSongsByArtist.size()]));
            allArtistsWithSongs.add(artistOutputDTO);
        }
        return allArtistsWithSongs;
    }
}
