package com.example.wp_lab.repository;

import com.example.wp_lab.bootstrap.DataHolder;
import com.example.wp_lab.model.Artist;
import com.example.wp_lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepository {
    public List<Song> findAll() {
        return DataHolder.songList;
    }

    public Song findByTrackId(String trackId) {
        return DataHolder.songList.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    public Artist addArtistToSong(Artist artist, Song song) {
        song.addPerformer(artist);
        return artist;
    }
}
