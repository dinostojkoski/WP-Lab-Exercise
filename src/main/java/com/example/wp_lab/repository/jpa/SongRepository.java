package com.example.wp_lab.repository.jpa;

import com.example.wp_lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findAllByAlbum_Id(Long albumId);
    // void addArtistToSong(Song song, Artist artist);
}
