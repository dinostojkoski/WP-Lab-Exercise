package com.example.wp_lab.repository.impl;

import com.example.wp_lab.bootstrap.DataHolder;
import com.example.wp_lab.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryAlbumRepository {

    public List<Album> findAll() {
        return DataHolder.albumList;
    }
}
