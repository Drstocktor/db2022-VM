package se.iths;

import java.util.HashMap;

public class Artist {
    private final Long ARTIST_ID;
    private String name;
    private HashMap<Long, Album> albums = new HashMap<>();
    private HashMap<Long, Track> tracks = new HashMap<>();
    public Artist(Long artistId, String name) {
        ARTIST_ID = artistId;
        this.name = name;
    }
    public Long getARTIST_ID() {
        return ARTIST_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Long, Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album album) {
        this.albums.put(album.getALBUM_ID(), album);
    }

    public void setTracks(HashMap<Long, Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "ARTIST_ID=" + ARTIST_ID +
                ", name='" + name + '\'' +
                '}';
    }
}
