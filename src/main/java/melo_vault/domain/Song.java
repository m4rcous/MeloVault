package melo_vault.domain;

import java.util.Objects;

public class Song {
    private int id;
    private String title;
    private String artist;
    private String album;
    private String genre;
    private Integer year;
    private String url;

    public Song() {}

    // Search by id
    public Song(int id) {
        this.id = id;
    }

    // Search by genre, artist or album
    enum SearchType {ARTIST, GENRE, ALBUM};

    public Song(String value, SearchType type) {
        switch (type) {
            case ARTIST -> this.artist = value;
            case GENRE -> this.genre = value;
            case ALBUM -> this.album = value;
        }
    }

    // Search by year
    public Song(Integer year) {
        this.year = year;
    }

    public Song(String title, String artist, String album, String genre, Integer year, String url) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.year = year;
        this.url = url;
    }

    public Song(int id, String title, String artist, String album, String genre, Integer year, String url) {
        this(title, artist, album, genre, year, url);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return String.format("Song [ID: %d]\nTitle : %s\nArtist : %s\nAlbum : %s\nGenre : %s\nYear : %s\nUrl : %s\n",
                this.id,
                this.title,
                this.artist,
                (this.album != null ? this.album : "N/A"),
                (this.genre != null ? this.genre : "N/A"),
                (this.year != null ? this.year.toString() : "N/A"),
                (this.url != null ? this.url : "N/A"));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return id == song.id && Objects.equals(title, song.title) && Objects.equals(artist, song.artist) && Objects.equals(album, song.album) && Objects.equals(genre, song.genre) && Objects.equals(year, song.year) && Objects.equals(url, song.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, artist, album, genre, year, url);
    }
}
