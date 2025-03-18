package melo_vault.data;

import melo_vault.domain.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static melo_vault.connection.ConnectionMeloVaultDB.getConnection;

public class SongDAO implements ISongDAO {
    @Override
    public List<Song> listSongs() {
        // Preparamos una lista vacía de canciones
        List<Song> songs = new ArrayList<>();

        // También el envío la consulta y el resultado de esta
        PreparedStatement ps;
        ResultSet rs;

        // Y la conexión obtenida
        Connection con = getConnection();

        var sql = "SELECT * FROM song ORDER BY id ASC";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Song song = new Song();

                song.setId(rs.getInt("id"));
                song.setTitle(rs.getString("title"));
                song.setArtist(rs.getString("artist"));
                song.setAlbum(rs.getString("album"));
                song.setGenre(rs.getString("genre"));
                song.setYear(rs.getInt("year"));
                song.setUrl(rs.getString("url"));

                songs.add(song);
            }

        } catch (Exception e) {
            System.out.println("Error listing songs: " + e.getMessage());
        }
        finally {
            try {
                con.close();

            } catch (Exception e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }

        return songs;
    }

    @Override
    public boolean searchSongbyId(Song song) {
        PreparedStatement ps;
        ResultSet rs;

        Connection con = getConnection();

        var sql = "SELECT * FROM song WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, song.getId());

            rs = ps.executeQuery();

            if (rs.next()) {
                song.setTitle(rs.getString("title"));
                song.setArtist(rs.getString("artist"));
                song.setAlbum(rs.getString("album"));
                song.setGenre(rs.getString("genre"));
                song.setYear(rs.getInt("year"));
                song.setUrl(rs.getString("url"));

                return true;
            }

        } catch (Exception e) {
            System.out.println("Error searching song by id: " + e.getMessage());
        }
        finally {
            try {
                con.close();

            } catch (Exception e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }

        return false;
    }

    @Override
    public List<Song> listSongsbyArtist(String artist) {
        List<Song> songs = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        Connection con = getConnection();

        var sql = "SELECT * FROM song WHERE artist = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, artist);

            rs = ps.executeQuery();

            while (rs.next()) {
                Song song = new Song();

                song.setId(rs.getInt("id"));
                song.setTitle(rs.getString("title"));
                song.setArtist(rs.getString("artist"));
                song.setAlbum(rs.getString("album"));
                song.setGenre(rs.getString("genre"));
                song.setYear(rs.getInt("year"));
                song.setUrl(rs.getString("url"));

                songs.add(song);
            }

        } catch (Exception e) {
            System.out.println("Error listing songs by artist: " + e.getMessage());
        }
        finally {
            try {
                con.close();

            } catch (Exception e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }

        return songs;
    }

    @Override
    public List<Song> listSongsbyGenre(String genre) {
        List<Song> songs = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        Connection con = getConnection();

        var sql = "SELECT * FROM song WHERE genre = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, genre);

            rs = ps.executeQuery();

            while (rs.next()) {
                Song song = new Song();

                song.setId(rs.getInt("id"));
                song.setTitle(rs.getString("title"));
                song.setArtist(rs.getString("artist"));
                song.setAlbum(rs.getString("album"));
                song.setGenre(rs.getString("genre"));
                song.setYear(rs.getInt("year"));
                song.setUrl(rs.getString("url"));

                songs.add(song);
            }

        } catch (Exception e) {
            System.out.println("Error listing songs by genre: " + e.getMessage());
        }
        finally {
            try {
                con.close();

            } catch (Exception e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }

        return songs;
    }

    @Override
    public List<Song> listSongsbyAlbum(String album) {
        List<Song> songs = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        Connection con = getConnection();

        String sql;

        // album puede ser NULL
        if (album == null)
            sql = "SELECT * FROM song WHERE album IS NULL";
        else
            sql = "SELECT * FROM song WHERE album = ?";

        try {
            ps = con.prepareStatement(sql);

            if (album != null)
                ps.setString(1, album);

            rs = ps.executeQuery();

            while (rs.next()) {
                Song song = new Song();

                song.setId(rs.getInt("id"));
                song.setTitle(rs.getString("title"));
                song.setArtist(rs.getString("artist"));
                song.setAlbum(rs.getString("album"));
                song.setGenre(rs.getString("genre"));
                song.setYear(rs.getInt("year"));
                song.setUrl(rs.getString("url"));

                songs.add(song);
            }

        } catch (Exception e) {
            System.out.println("Error searching song by album: " + e.getMessage());
        }
        finally {
            try {
                con.close();

            } catch (Exception e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }

        return songs;
    }

    @Override
    public List<Song> listSongsbyYear(Integer year) {
        List<Song> songs = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        Connection con = getConnection();

        var sql = "SELECT * FROM song WHERE year = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, year);

            rs = ps.executeQuery();

            while (rs.next()) {
                Song song = new Song();

                song.setId(rs.getInt("id"));
                song.setTitle(rs.getString("title"));
                song.setArtist(rs.getString("artist"));
                song.setAlbum(rs.getString("album"));
                song.setGenre(rs.getString("genre"));
                song.setYear(rs.getInt("year"));
                song.setUrl(rs.getString("url"));

                songs.add(song);
            }

        } catch (Exception e) {
            System.out.println("Error listing songs by year: " + e.getMessage());
        }
        finally {
            try {
                con.close();

            } catch (Exception e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }

        return songs;
    }

    @Override
    public boolean addSong(Song song) {
        PreparedStatement ps;
        ResultSet rs;

        Connection con = getConnection();

        var sql = "INSERT INTO song(title, artist, album, genre, year, url) "
                + " VALUES(?, ?, ?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, song.getTitle());
            ps.setString(2, song.getArtist());
            ps.setString(3, song.getAlbum());
            ps.setString(4, song.getGenre());
            ps.setInt(5, song.getYear());
            ps.setString(6, song.getUrl());

            ps.execute();

            return true;

        } catch (Exception e) {
            System.out.println("Error adding song: " + e.getMessage());
        }
        finally {
            try {
                con.close();

            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }

        return false;
    }

    @Override
    public boolean updateSong(Song song) {
        PreparedStatement ps;

        Connection con = getConnection();

        var sql = "UPDATE song SET title = ?, artist = ?, album = ?, genre = ?, year = ?, url = ? "
                + " WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, song.getTitle());
            ps.setString(2, song.getArtist());
            ps.setString(3, song.getAlbum());
            ps.setString(4, song.getGenre());
            ps.setInt(5, song.getYear());
            ps.setString(6, song.getUrl());

            ps.setInt(7, song.getId());

            ps.execute();

            return true;

        } catch (Exception e) {
            System.out.println("Error updating song: " + e.getMessage());
        }
        finally {
            try {
                con.close();

            } catch (Exception e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }

        return false;
    }

    @Override
    public boolean deleteSong(Song song) {
        PreparedStatement ps;

        Connection con = getConnection();

        var sql = "DELETE FROM song WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, song.getId());

            ps.execute();

            return true;

        } catch (Exception e) {
            System.out.println("Error deleting song: " + e.getMessage());
        }
        finally {
            try {
                con.close();

            } catch (Exception e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Melo Vault!");
        System.out.println("----------------------------------");

        ISongDAO songDAO = new SongDAO();

        // List songs by X
//        var songs = songDAO.listSongsbyAlbum(null);
//
//        if (songs.isEmpty()) {
//            System.out.println("No songs found");
//
//        } else {
//            System.out.println("We found " + songs.size() + " songs");
//            songs.forEach(System.out::println);
//        }

        // Search songs by ID

//        var test = new Song(3);
//
//        var encontrado = songDAO.searchSongbyId(test);
//
//        if (encontrado)
//            System.out.println("Song found:\n" + test);
//        else
//            System.out.println("Song not found with id: " + test.getId());

        // Add new song and verify
//        var newSong = new Song("Ventura Highway", "America", "America", "Folk Rock", 1971, "https://www.youtube.com/watch?v=tnV7dTXlXxs");
//
//        var added = songDAO.addSong(newSong);
//
//        if (added)
//            System.out.println("""
//
//                    Song added successfully!
//                    """);
//        else
//            System.out.println("""
//
//                    Song not added successfully
//                    """);

//        // Update a song
//        // new changes:
//        // album: America -> Homecoming
//        // year: 1971 -> 1972
//        var updateSong = new Song(7, "Ventura Highway", "America", "Homecoming", "Folk Rock", 1972, "https://www.youtube.com/watch?v=tnV7dTXlXxs");
//
//        var updated = songDAO.updateSong(updateSong);
//
//        if (updated)
//            System.out.printf("""
//
//                    Song with ID %d was updated!
//
//                    """, updateSong.getId());
//        else
//            System.out.printf("""
//
//                    Song with ID %d was not updated
//
//                    """, updateSong.getId());
//
         // Delete a song
//        var deleteSong = new Song(5);
//        var deleted = songDAO.deleteSong(deleteSong);
//
//        if (deleted)
//            System.out.printf("""
//
//                    Song with ID %d was deleted!
//
//                    """, deleteSong.getId());
//        else
//            System.out.printf("""
//
//                    Song with ID %d was not deleted
//
//                    """, deleteSong.getId());
//
//        var songs = songDAO.listSongs();
//
//        if (songs.isEmpty()) {
//            System.out.println("No songs found");
//
//        } else {
//            System.out.println("We found " + songs.size() + " songs");
//            songs.forEach(System.out::println);
//        }
    }
}
