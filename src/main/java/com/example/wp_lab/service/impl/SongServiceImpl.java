package com.example.wp_lab.service.impl;

import com.example.wp_lab.bootstrap.DataHolder;
import com.example.wp_lab.model.Album;
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
    public Song findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public Song save(String title, String genre, int releaseYear, Album album) {
        Song song = new Song(title, genre, releaseYear, album);
        return songRepository.save(title, genre, releaseYear, album);
    }

    @Override
    public Song update(Long id, String title, String genre, int releaseYear, Album album) {
        return songRepository.updateSong(id, title, genre, releaseYear, album);
    }

    @Override
    public void delete(Long id) {
        songRepository.delete(id);
    }
}
