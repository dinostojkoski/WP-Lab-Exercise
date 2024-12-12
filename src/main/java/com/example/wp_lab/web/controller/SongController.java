package com.example.wp_lab.web.controller;

import com.example.wp_lab.model.Album;
import com.example.wp_lab.model.Song;
import com.example.wp_lab.service.AlbumService;
import com.example.wp_lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    // Get Song Page
    @GetMapping
    public String getSongsPage(@RequestParam(required = false) Long albumId, Model model) {
        List<Song> songList = songService.listSongs();
        List<Album> albumList = albumService.findAll();

        if (albumId != null) {
            // If an albumId is provided, search for songs in that album
            songList = songService.findAllByAlbum_Id(albumId);
        } else {
            // Otherwise, display all songs
            songList = songService.listSongs();
        }

        model.addAttribute("songList", songList);
        model.addAttribute("albumList", albumList);
        return "listSongs";
    }

    // Get the Edit Song Page
    @GetMapping("/edit/{id}")
    public String editSong(@PathVariable Long id, Model model) {
        Song song = songService.findById(id);
        List<Album> albumList = albumService.findAll();

        model.addAttribute("song", song);
        model.addAttribute("albumList", albumList);
        return "add-song";
    }

    // Add New Song Page
    @GetMapping("/add-form")
    public String addSongPage(Model model) {
        List<Album> albumList = albumService.findAll();
        model.addAttribute("albumList", albumList);
        return "add-song";
    }

    // Delete Song
    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.delete(id);
        return "redirect:/songs";
    }

    // Update or Add New Song
    @PostMapping("/add")
    public String saveSong( @RequestParam(required = false) Long id, @RequestParam String title,
            @RequestParam String genre, @RequestParam int releaseYear, @RequestParam Long albumId) {

        Album album = albumService.findAll().stream().filter(a -> a.getId().equals(albumId)).findFirst().orElse(null);

        if (id != null) {
            songService.update(id, title, genre, releaseYear, album);
        } else {
            songService.save(title, genre, releaseYear, album);
        }
        return "redirect:/songs";
    }
}
