package com.example.wp_lab.repository;

import com.example.wp_lab.bootstrap.DataHolder;
import com.example.wp_lab.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepository {

    public List<Album> findAll() {
        return DataHolder.albumList;
    }
}
