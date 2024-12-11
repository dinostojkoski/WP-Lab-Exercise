package com.example.wp_lab.web.controller;

import com.example.wp_lab.model.Artist;
import com.example.wp_lab.model.Song;
import com.example.wp_lab.service.ArtistService;
import com.example.wp_lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

@Controller
@RequestMapping("/songDetails")
public class SongDetailsController {

    private final SongService songService;
    private final ArtistService artistService;

    public SongDetailsController(SongService songService, ArtistService artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }

    @GetMapping
    public String songDetails(@RequestParam Long id, @RequestParam Long artistId, Model model) {
        Song song = songService.findById(id);
        Artist artist = artistService.findById(artistId);

        if (song != null && artist != null) {
            song.addPerformer(artist);
        }

        model.addAttribute("song", song);
        return "songDetails";
    }
}
