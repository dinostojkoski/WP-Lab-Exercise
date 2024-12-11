package com.example.wp_lab.web.controller;

import com.example.wp_lab.model.Artist;
import com.example.wp_lab.service.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping()
    public String getArtists(@RequestParam Long id, Model model) {
        List<Artist> artistList = artistService.listArtists();

        model.addAttribute("artistList", artistList);
        model.addAttribute("id", id);

        return "artistsList";
    }
}
