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
        if(languages.stream().anyMatch(l -> l.equals(language))){
            System.out.println("You already have selected this language");
            return;
        }
        this.languages.add(language);
        System.out.println("You can now play songs in: " + language);
    }

    public void removeLanguage(Language language) {
        languages.removeIf(l -> l.equals(language));
        System.out.println(language + " deleted from your preferences");
    }

    public Playlist createPlaylist (String name) {
        if (playlists.stream().anyMatch(p -> p.getName().equals(name))){
            System.out.println("Playlist already exists");
            return null;
        };
        Playlist playlist = new Playlist(name);
        playlists.add(playlist);
        System.out.println("Playlist " + name + " created for user " + this.userID);
        return playlist;
    }

    public void deletePlaylist (String name) {
        if(playlists.removeIf(p -> p.getName().equals(name))){
            System.out.println("Playlist " + name + " deleted for user " + this.userID);
            return;
        }
        System.out.println("Playlist doesn't exist");
    }

    public void addToPlaylist (String name, Music newMusic) {
        playlists.parallelStream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .ifPresentOrElse(
                        p -> p.addMusic(newMusic),
                        () -> System.out.println(this.userID +" doesn't have playlist " + name)
                );
    }

    public void deleteFromPlaylist (String name, Music oldMusic) {
        playlists.parallelStream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .ifPresentOrElse(
                        p -> p.removeMusic(oldMusic),
                        () -> System.out.println(this.userID +" doesn't have playlist " + name)
                );
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
        languages.parallelStream()
                .forEach(System.out::println);
    }
}
