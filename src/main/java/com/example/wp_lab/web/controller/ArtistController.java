package com.example.wp_lab.web.controller;

import com.example.wp_lab.model.Album;
import com.example.wp_lab.model.Artist;
import com.example.wp_lab.model.Song;
import com.example.wp_lab.service.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    // Get Artists Page
    @GetMapping()
    public String getArtistsPage(@RequestParam Long id, Model model) {
        List<Artist> artistList = artistService.listArtists();

        model.addAttribute("artistList", artistList);
        model.addAttribute("id", id);

        return "artistsList";
    }

    // Add New Song Page
    @GetMapping("/add-form")
    public String addArtistPage() {
        return "add-artist";
    }

    // Update or Add New Song
    @PostMapping("/add")
    public String saveArtist( @RequestParam(required = false) Long id, @RequestParam String name,
                            @RequestParam String surname, @RequestParam String bio) {

        if (id != null) {
            artistService.updateArtist(id, name, surname, bio);
        } else {
            artistService.saveArtist(name, surname, bio);
        }
        return "redirect:/artists";
    }
}
