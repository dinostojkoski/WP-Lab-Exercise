package com.example.wp_lab.service;

import com.example.wp_lab.model.Album;
import com.example.wp_lab.model.Artist;
import com.example.wp_lab.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    // void addArtistToSong(Song song, Artist artist);
    Song findById(Long id);
    void save(String title, String genre, int releaseYear, Album album);
    void update(Long id, String title, String genre, int releaseYear, Album album);
    void delete(Long id);
    List<Song> findAllByAlbum_Id(Long id);
}
