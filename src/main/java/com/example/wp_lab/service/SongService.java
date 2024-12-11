package com.example.wp_lab.service;

import com.example.wp_lab.model.Artist;
import com.example.wp_lab.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Song findByTrackId(String trackId);
}
