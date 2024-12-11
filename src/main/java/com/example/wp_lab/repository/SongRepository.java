package com.example.wp_lab.repository;

import com.example.wp_lab.bootstrap.DataHolder;
import com.example.wp_lab.model.Album;
import com.example.wp_lab.model.Artist;
import com.example.wp_lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepository {
    public List<Song> findAll() {
        return DataHolder.songList;
    }

    public Song findById(Long id) {
        return DataHolder.songList.stream().filter(song -> song.getId().equals(id)).findFirst().orElse(null);
    }

    public Artist addArtistToSong(Artist artist, Song song) {
        song.addPerformer(artist);
        return artist;
    }

    public Song save(String title, String genre, int releaseYear, Album album) {
        Song song = new Song(title, genre, releaseYear, album);
        DataHolder.songList.add(song);
        return song;
    }

    public Song updateSong(Long id, String title, String genre, int releaseYear, Album album) {
        Song song = DataHolder.songList.stream().filter(song1 -> song1.getId().equals(id)).findFirst().orElse(null);
        if (song != null) {
            song.setTitle(title);
            song.setGenre(genre);
            song.setReleaseYear(releaseYear);
            song.setAlbum(album);
        }
        return song;
    }

    public void delete(Long id) {
        DataHolder.songList.removeIf(song -> song.getId().equals(id));
    }
}
