package se.iths;

public class Track {
    private final long TRACK_ID;
    private String trackName;

    public Track(long trackId, String trackName) {
        TRACK_ID = trackId;
        this.trackName = trackName;
    }

    public long getTRACK_ID() {
        return TRACK_ID;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackName='" + trackName + '\'' +
                '}';
    }
}
