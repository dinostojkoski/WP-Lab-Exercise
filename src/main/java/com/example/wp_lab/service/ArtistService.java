package com.example.wp_lab.service;

import com.example.wp_lab.model.Artist;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ArtistService {
    List<Artist> listArtists();
    Artist findById(Long id);
    void saveArtist(String name, String surname, String bio);
    void updateArtist(Long id, String name, String surname, String bio);
}
