package com.example.wp_lab.web;

import com.example.wp_lab.model.Artist;
import com.example.wp_lab.model.Song;
import com.example.wp_lab.service.ArtistService;
import com.example.wp_lab.service.SongService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "song-details-servlet", urlPatterns = "/songDetails")
public class SongDetailsServlet extends HttpServlet {

    private final SongService songService;
    private final ArtistService artistService;
    private final SpringTemplateEngine templateEngine;

    public SongDetailsServlet(SongService songService, ArtistService artistService, SpringTemplateEngine templateEngine) {
        this.songService = songService;
        this.artistService = artistService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId = req.getParameter("trackId");
        Long artistId = Long.parseLong(req.getParameter("artistId"));

        Song song = songService.findByTrackId(trackId);
        Artist artist = artistService.findById(artistId);

        if (song != null && artist != null) {
            song.addPerformer(artist);
        }

        IWebExchange WebExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(WebExchange);

        context.setVariable("song", song);
        templateEngine.process("songDetails.html", context, resp.getWriter());
    }

    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long trackId = Long.valueOf(req.getParameter("trackId"));
        String artistId = req.getParameter("artistId");

        Song song = Optional.of(songService.listSongs().stream().findFirst()).orElseThrow().orElse(null);

        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(iWebExchange);
        context.setVariable("song", song);
        templateEngine.process("songDetails.html", context, resp.getWriter());
    }*/
}
