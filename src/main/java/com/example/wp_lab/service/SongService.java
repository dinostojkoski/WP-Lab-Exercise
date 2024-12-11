package com.example.wp_lab.service;

import com.example.wp_lab.model.Album;
import com.example.wp_lab.model.Artist;
import com.example.wp_lab.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Song findById(Long id);
    public Song save(String title, String genre, int releaseYear, Album album);
    public Song update(Long id, String title, String genre, int releaseYear, Album album);
    public void delete(Long id);
}
