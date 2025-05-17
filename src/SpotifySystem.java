package src;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SpotifySystem {
    private static volatile SpotifySystem instance;
    private final Map<String, Music> musics;
    private final Map<String, User> users;

    private SpotifySystem() {
        this.users = new HashMap<>();
        this.musics = new HashMap<>();
    }

    public synchronized static SpotifySystem getInstance() {
        if(instance == null) {
            synchronized (SpotifySystem.class){
                if(instance == null){
                    instance = new SpotifySystem();
                }
            }
        }
        return instance;
    }

    public User addUser(String password) {
        String id = "US" + UUID.randomUUID().toString().substring(0,8);
        User user = new User(id, password);
        users.put(id, user);
        System.out.println("User created with id " + id);
        return user;
    }

    public void deleteUser(String id) {
        users.remove(id);
        System.out.println("User deleted with id " + id);
    }

    public Music addMusic (Genre genre, Language language, String artist, int duration, String name) {
        String id = "MU" + UUID.randomUUID().toString().substring(0,8);
        Music music = new Music(genre, language, artist, duration, id, name);
        musics.put(id, music);
        System.out.println("Music added in system with id " + id);
        return music;
    }

    public void searchMusic(String query) {
        System.out.println("Search results:");
        musics.values().stream()
                .filter(music -> music.getArtist().equals(query) || music.getName().equals(query))
                .forEach(music -> System.out.println(music.getName() + " By " + music.getArtist()));
    }

    public void addLanguage(Language language, User user) {
        if(users.containsKey(user.getUserID())) {
            users.get(user.getUserID()).addLanguage(language);
            return;
        }
        System.out.println("User not there in system");
    }

    public void removeLanguage(Language language, User user) {
        if(users.containsKey(user.getUserID())) {
            users.get(user.getUserID()).removeLanguage(language);
            return;
        }
        System.out.println("User not there in system");
    }

    public Playlist createPlaylist (String name, User user) {
        if(users.containsKey(user.getUserID())) {
           return users.get(user.getUserID()).createPlaylist(name);
        }
        System.out.println("User not there in system");
        return null;
    }

    public void deletePlaylist (String name, User user) {
        if(users.containsKey(user.getUserID())) {
            users.get(user.getUserID()).deletePlaylist(name);
            return;
        }
        System.out.println("User not there in system");
    }

    public void addMusicToPlaylist (String name, User user, Music music) {
        if(musics.containsKey(music.getId()) && users.containsKey(user.getUserID())) {
            users.get(user.getUserID()).addToPlaylist(name, music);
            return;
        }
        System.out.println("Music or user not there in system");
    }

    public void deleteMusicFromPlaylist (String name, User user, Music music) {
        if(musics.containsKey(music.getId()) && users.containsKey(user.getUserID())) {
            users.get(user.getUserID()).deleteFromPlaylist(name, music);
            return;
        }
        System.out.println("Music or user not there in system");
    }

    public void displayPlaylist(User user) {
        if(users.containsKey(user.getUserID())) {
            users.get(user.getUserID()).displayPlaylists();
            return;
        }
        System.out.println("User not there in system");
    }

    public void displayLanguages(User user) {
        if(users.containsKey(user.getUserID())) {
            users.get(user.getUserID()).displayLanguages();
            return;
        }
        System.out.println("User not there in system");
    }

    public void displayMusic() {
        musics.values()
                .forEach(music -> System.out.println(music.getName() + " by " + music.getArtist()));
    }

}
