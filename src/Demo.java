package src;

public class Demo {
    public static void main(String[] args) {
       SpotifySystem spotifySystem = SpotifySystem.getInstance();

       // Add music
       Music music1 = spotifySystem.addMusic(Genre.INSTRUMENTAL, Language.ENGLISH, "COLDPLAY", 45, "Hymn for the weekend");
       Music music2 = spotifySystem.addMusic(Genre.INSTRUMENTAL, Language.HINDI, "KK", 45, "Kabhi Kabhi");
       Music music3 = spotifySystem.addMusic(Genre.ROMANTIC, Language.HINDI, "RAM", 45, "Azab Gazab");
       Music music4 = spotifySystem.addMusic(Genre.POP, Language.ENGLISH, "ROBIN", 45, "DAVID");
       Music music5 = spotifySystem.addMusic(Genre.POP, Language.SPANISH, "CHARLIE", 45, "Hymn for");
       Music music6 = spotifySystem.addMusic(Genre.INSTRUMENTAL, Language.SPANISH, "DAVID", 45, "ROM COM");

       // Add users
       User user1 = spotifySystem.addUser("123456");
       User user2 = spotifySystem.addUser("654321");

       spotifySystem.displayMusic();
       spotifySystem.searchMusic("COLDPLAY");
       spotifySystem.searchMusic("DAVID");

       // create playlist
       Playlist playlist1 = spotifySystem.createPlaylist("action", user1);
       Playlist playlist2 = spotifySystem.createPlaylist("action", user1);
       Playlist playlist3 = spotifySystem.createPlaylist("action", user2);
       Playlist playlist4 = spotifySystem.createPlaylist("romance", user1);

       // add language
       spotifySystem.addLanguage(Language.HINDI, user1);
       spotifySystem.addLanguage(Language.ENGLISH, user1);
       spotifySystem.addLanguage(Language.SPANISH, user2);
       spotifySystem.addLanguage(Language.SPANISH, user2);

       // add music in playlist
       spotifySystem.addMusicToPlaylist(playlist1.getName(), user1, music1);
       spotifySystem.addMusicToPlaylist(playlist1.getName(), user1, music1);
       spotifySystem.addMusicToPlaylist(playlist1.getName(), user1, music2);
       spotifySystem.addMusicToPlaylist(playlist4.getName(), user1, music6);
       spotifySystem.addMusicToPlaylist(playlist4.getName(), user2, music5);

       // display languages
       spotifySystem.displayLanguages(user1);
       spotifySystem.displayLanguages(user2);

       // display playlists
       spotifySystem.displayPlaylist(user1);
       spotifySystem.displayPlaylist(user2);
    }
}
