package com.example.wp_lab.service.impl;

import com.example.wp_lab.model.Artist;
import com.example.wp_lab.repository.jpa.ArtistRepository;
import com.example.wp_lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    @Override
    public void saveArtist(String name, String surname, String bio) {
        Artist artist = new Artist(name, surname, bio);
        artistRepository.save(artist);
    }

    @Override
    public void updateArtist(Long id, String name, String surname, String bio) {
        Artist artist = artistRepository.findById(id).orElse(null);
        if (artist != null) {
            artist.setFirstName(artist.getFirstName());
            artist.setLastName(artist.getLastName());
            artist.setBio(artist.getBio());
            artistRepository.save(artist);
        }
    }
}
