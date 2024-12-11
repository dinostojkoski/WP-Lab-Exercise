package com.example.wp_lab.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Album {
    private static Long idCounter = 0L;
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;
    private List<Song> songs;

    public Album(String name, String genre, String releaseYear) {
        this.id = ++idCounter;
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.songs = new ArrayList<>();
    }

    // Add a song to this album
    public void addSong(Song song) {
        this.songs.add(song);
    }

    public static void setIdCounter(Long idCounter) {
        Album.idCounter = idCounter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
