package src;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final String name;
    private final List<Music> music;

    public Playlist(String name) {
        this.name = name;
        this.music = new ArrayList<>();
    }

    public void addMusic (Music newMusic) {
         long count =  music.stream()
                .filter(music1 -> music1.getId().equals(newMusic.getId()))
                .count();

         if(count > 0) {
             System.out.println("This music is already there in the playlist");
             return;
         }

        music.add(newMusic);
        System.out.println(newMusic.getName() + " added in playlist " + this.name);
    }

    public void removeMusic (Music oldMusic) {
        for (Music music1 : music) {
            if(music1.getId().equals(oldMusic.getId())) {
                music.remove(music1);
                System.out.println("music removed from playlist");
                return;
            }
        }
        System.out.println("Playlist doesn't have this music");
    }

    public String getName() {
        return name;
    }

    public void displayMusic() {
        System.out.println("Songs in playlist " + this.name  );
        music.forEach(music1 -> System.out.println(music1.getName() + " by " + music1.getArtist()));
    }
}
