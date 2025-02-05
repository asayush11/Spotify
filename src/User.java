package src;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String userID;
    private final String password;
    private final List<Playlist> playlists;
    private final List<Language> languages;

    public User(String userID, String password) {
        this.userID = userID;
        this.password = password;
        this.playlists = new ArrayList<>();
        this.languages = new ArrayList<>();
    }

    public void addLanguage( Language language) {
        long count = languages.stream()
                .filter(language1 -> language1.equals(language))
                .count();

        if(count > 0) {
            System.out.println("You already have selected this language");
            return;
        }
        this.languages.add(language);
        System.out.println("You can now play songs in: " + language);
    }

    public void removeLanguage(Language language) {
        for(Language language1 : languages) {
            if(language.equals(language1)) {
                languages.remove(language1);
                return;
            }
        }
        System.out.println(language + " deleted from your preferences");
    }

    public Playlist createPlaylist (String name) {
        for(Playlist playlist : playlists) {
            if(playlist.getName().equals(name)) {
                System.out.println("Playlist already exists");
                return null;
            }
        }
        Playlist playlist = new Playlist(name);
        playlists.add(playlist);
        System.out.println("Playlist " + name + " created for user " + this.userID);
        return playlist;
    }

    public void deletePlaylist (String name) {
        for(Playlist playlist : playlists) {
            if(playlist.getName().equals(name)) {
                System.out.println("Playlist " + name + " deleted for user " + this.userID);
                return;
            }
        }
        System.out.println("Playlist doesn't exist");
    }

    public void addToPlaylist (String name, Music newMusic) {
       for(Playlist playlist : playlists) {
           if(playlist.getName().equals(name)) {
               playlist.addMusic(newMusic);
               return;
           }
       }
       System.out.println("Playlist doesn't exist");
    }

    public void deleteFromPlaylist (String name, Music newMusic) {
        for(Playlist playlist : playlists) {
            if(playlist.getName().equals(name)) {
                playlist.removeMusic(newMusic);
                return;
            }
        }
        System.out.println("Playlist doesn't exist");
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public void displayPlaylists() {
        System.out.println("Playlists for user " + this.userID  );
        playlists
                .forEach(Playlist::displayMusic);
    }

    public void displayLanguages() {
        System.out.println("Language preferences for user " + this.userID  );
        languages
                .forEach(System.out::println);
    }
}
