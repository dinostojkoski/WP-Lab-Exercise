package com.example.wp_lab.service.impl;

import com.example.wp_lab.model.Album;
import com.example.wp_lab.repository.AlbumRepository;
import com.example.wp_lab.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }
}
