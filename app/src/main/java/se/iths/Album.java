package se.iths;

import java.util.HashMap;
import java.util.Map;

public class Album {
    private final Long ALBUM_ID;
    private String albumTitle;
    private Map<Long, Track> tracks = new HashMap<>();

    public Album(Long albumId, String albumTitle) {
        ALBUM_ID = albumId;
        this.albumTitle = albumTitle;
    }

    public Long getALBUM_ID() {
        return ALBUM_ID;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public Map<Long, Track> getTracks() {
        return tracks;
    }

    @Override
    public String toString() {
        return "Album{" +
                "ALBUM_ID=" + ALBUM_ID +
                ", albumTitle='" + albumTitle + '\'' +
                ", tracks=" + tracks.get(ALBUM_ID).toString()+
                '}';
    }

    public void addTrack(Track track) {
        this.tracks.put(ALBUM_ID, track);
    }
}
