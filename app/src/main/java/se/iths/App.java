package se.iths;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class App {
    static HashMap<Long, Artist> artists = new HashMap<>();
    static HashMap<Long, Album> albums = new HashMap<>();
    public static final String SQL_SELECT_ALL_ARTISTS = "select ArtistId, AlbumID, Name, Title from Artist join Album using (ArtistId)";
    public static final String SQL_SELECT_ALL_TRACKS = "select TrackId, Name from Track join Album using (AlbumId)";

    public static void main(String[] args) {
        importArtistsAndAlbums();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Chinook", "iths", "iths");
            ResultSet resultSet = connection.createStatement().executeQuery(SQL_SELECT_ALL_TRACKS);
            while (resultSet.next()) {
                long trackId = resultSet.getLong("TrackId");
                String name = resultSet.getString("Name");

                Track track = new Track(trackId, name);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void importArtistsAndAlbums() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Chinook", "iths", "iths");
            ResultSet resultSet = connection.createStatement().executeQuery(SQL_SELECT_ALL_ARTISTS);
            while (resultSet.next()) {
                long artistID = resultSet.getLong("ArtistId");
                String name = resultSet.getString("Name");
                long albumID = resultSet.getLong("AlbumID");
                String title = resultSet.getString("Title");

                Artist artist = new Artist(artistID, name);
                artist = addArtist(artistID, artist);

                Album album = new Album(albumID, title);
                addAlbum(albumID, artist, album);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static Artist addArtist(long artistID, Artist artist) {
        if (artists.containsKey(artistID)) {
            artist = artists.get(artistID);
        } else {
            artists.put(artistID, artist);
            System.out.println(artist);
        }
        return artist;
    }

    private static void addAlbum(long albumID, Artist artist, Album album) {
        if (albums.containsKey(albumID)) {
            album = albums.get(albumID);
        } else {
            albums.put(albumID, album);
            artist.addAlbum(album);
        }
    }

}