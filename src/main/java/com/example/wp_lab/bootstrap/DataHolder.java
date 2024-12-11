package com.example.wp_lab.bootstrap;

import com.example.wp_lab.model.Artist;
import com.example.wp_lab.model.Song;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artistList = new ArrayList<>();
    public static List<Song> songList = new ArrayList<>();

    @PostConstruct
    public void init() {
        artistList.add(new Artist(1L, "Freddie", "Mercury", "Lead vocalist of Queen, one of the greatest rock performers."));
        artistList.add(new Artist(2L, "Michael", "Jackson", "The King of Pop, known for his iconic dance moves and vocals."));
        artistList.add(new Artist(3L, "Stevie", "Wonder", "A legendary singer-songwriter and multi-instrumentalist."));
        artistList.add(new Artist(4L, "Eric", "Clapton", "One of the most successful and influential guitarists in rock music."));
        artistList.add(new Artist(5L, "Elton", "John", "A world-famous pianist and composer of classic pop and rock hits."));

        songList.add(new Song("a", "Bohemian Rhapsody", "Rock", 1975)); // A Night at the Opera
        songList.add(new Song("b", "Billie Jean", "Pop", 1982)); // Thriller
        songList.add(new Song("c", "Isn't She Lovely", "Soul", 1976)); // Songs in the Key of Life
        songList.add(new Song("d", "Layla", "Rock", 1973)); // 21
        songList.add(new Song("e", "Candle in the Wind", "Rock/Pop", 1973)); // Goodbye Yellow Brick Road

    }
}
