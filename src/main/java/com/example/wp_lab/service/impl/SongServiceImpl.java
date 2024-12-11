package com.example.wp_lab.service.impl;

import com.example.wp_lab.model.Artist;
import com.example.wp_lab.model.Song;
import com.example.wp_lab.repository.SongRepository;
import com.example.wp_lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        songRepository.addArtistToSong(artist, song);
        return artist;
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }
}
