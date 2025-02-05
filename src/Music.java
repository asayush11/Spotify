package src;

public class Music {
    private final Genre genre;
    private final String name;
    private final Language language;
    private final String artist;
    private final int duration;
    private final String id;

    public Music(Genre genre, Language language, String artist, int duration, String id, String name) {
        this.genre = genre;
        this.language = language;
        this.artist = artist;
        this.duration = duration;
        this.name = name;
        this.id = id;
    }

    public Genre getGenre() {
        return genre;
    }

    public Language getLanguage() {
        return language;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
