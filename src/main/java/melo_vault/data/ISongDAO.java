package melo_vault.data;

import melo_vault.domain.Song;

import java.util.List;

public interface ISongDAO {
    List<Song> listSongs();
    boolean searchSongbyId(Song song);
    List<Song> listSongsbyArtist(String artist);
    List<Song> listSongsbyGenre(String genre);
    List<Song> listSongsbyAlbum(String album);
    List<Song> listSongsbyYear(Integer year);
    boolean addSong(Song song);
    boolean updateSong(Song song);
    boolean deleteSong(Song song);
}
