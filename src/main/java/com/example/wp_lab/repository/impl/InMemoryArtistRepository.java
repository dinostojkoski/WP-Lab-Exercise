package com.example.wp_lab.repository.impl;

import com.example.wp_lab.bootstrap.DataHolder;
import com.example.wp_lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryArtistRepository {
    public List<Artist> findAll() {
        return DataHolder.artistList;
    }

    public Optional<Artist> findById(Long id) {
        return DataHolder.artistList.stream().filter(artist -> artist.getId().equals(id)).findFirst();
    }
}
