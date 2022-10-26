package com.example.MusicApplication.repositories;

import com.example.MusicApplication.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song> findByArtistId(int ArtistId);
}
