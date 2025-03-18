package melo_vault.presentation;

import melo_vault.data.ISongDAO;
import melo_vault.data.SongDAO;
import melo_vault.domain.Song;

import java.util.Scanner;

import static melo_vault.presentation.Text.textCustom;

public class AppMeloVault {
    public static void main(String[] args) {
        meloVault();
    }

    private static void meloVault() {
        var console = new Scanner(System.in);

        ISongDAO songDAO = new SongDAO();

        var exit = false;

        textCustom("WELCOME TO MELO VAULT", 4, 1, '█', '▄');

        while (!exit) {
            try {
                var option = menu(console);
                System.out.println();
                exit = executeOptions(option, songDAO, console);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            finally {
                System.out.println();
            }
        }
    }

    private static int menu(Scanner console) {
        System.out.print("""
                Chose an option :D
                
                1. List songs
                2. Add a new song
                3. Update a song
                4. Delete a song
                
                5. Exit
                
                and is ...\s""");

        return Integer.parseInt(console.nextLine());
    }

    private static boolean executeOptions(int option, ISongDAO songDAO, Scanner console) {
        var exit = false;

        switch (option) {
            case 1 -> {
                System.out.print("""
                -------------------------------------------
                    Choose a listing mode :y
                    1. List all songs
                    2. List songs by artist
                    3. List songs by genre
                    4. List songs by album
                    5. List songs by year
                
                    and is...\s""");

                var optionCase1 = Integer.parseInt(console.nextLine());

                executeOptionsCase1(optionCase1, songDAO, console);
            }
            case 2 -> addSong(songDAO, console);
            case 3 -> updateSong(songDAO, console);
            case 4 -> deleteSong(songDAO, console);
            case 5 -> {
                System.out.println("See you soon! :)");
                exit = true;
            }
            default -> System.out.println("That is not a valid option! :T");
        }

        return exit;
    }

    private static void executeOptionsCase1(int optionCase1, ISongDAO songDAO, Scanner console) {
        switch (optionCase1) {
            case 1 -> listSongs(songDAO);
            case 2 -> listSongsbyArtist(songDAO, console);
            case 3 -> listSongsbyGenre(songDAO, console);
            case 4 -> listSongsbyAlbum(songDAO, console);
            case 5 -> listSongsbyYear(songDAO, console);
            default -> System.out.println("That is not a valid option! :T");
        }
    }

    private static void listSongs(ISongDAO songDAO) {
        var songs = songDAO.listSongs();

        if (songs.isEmpty()) {
            System.out.println("No songs found");

        } else {
            System.out.println("We found " + songs.size() + " songs");
            songs.forEach(System.out::println);
        }
    }

    private static void listSongsbyArtist(ISongDAO songDAO, Scanner console) {
        System.out.print("Let me know the artist: ");
        var artist = console.nextLine();

        var songs = songDAO.listSongsbyArtist(artist);

        if (songs.isEmpty()) {
            System.out.println("No songs found");

        } else {
            System.out.println("We found " + songs.size() + " songs");
            songs.forEach(System.out::println);
        }
    }

    private static void listSongsbyGenre(ISongDAO songDAO, Scanner console) {
        System.out.print("Let me know the genre: ");
        var genre = console.nextLine();

        var songs = songDAO.listSongsbyGenre(genre);

        if (songs.isEmpty()) {
            System.out.println("No songs found");

        } else {
            System.out.println("We found " + songs.size() + " songs");
            songs.forEach(System.out::println);
        }
    }

    private static void listSongsbyAlbum(ISongDAO songDAO, Scanner console) {
        System.out.print("Let me know the album: ");
        var album = console.nextLine();

        var songs = songDAO.listSongsbyAlbum(album);

        if (songs.isEmpty()) {
            System.out.println("No songs found");

        } else {
            System.out.println("We found " + songs.size() + " songs");
            songs.forEach(System.out::println);
        }
    }

    private static void listSongsbyYear(ISongDAO songDAO, Scanner console) {
        System.out.print("Let me know the year: ");
        var year = Integer.parseInt(console.nextLine());

        var songs = songDAO.listSongsbyYear(year);

        if (songs.isEmpty()) {
            System.out.println("No songs found");

        } else {
            System.out.println("We found " + songs.size() + " songs");
            songs.forEach(System.out::println);
        }
    }

    private static void addSong(ISongDAO songDAO, Scanner console) {
        System.out.print("""
                -------------------------------------------
                Let's add some data of the song!
                """);

        System.out.print("Enter the title: ");
        var title = console.nextLine();
        System.out.print("Enter the artist: ");
        var artist = console.nextLine();
        System.out.print("Enter the album: ");
        var album = console.nextLine();
        System.out.print("Enter the genre: ");
        var genre = console.nextLine();
        System.out.print("Enter the year: ");
        var year = Integer.parseInt(console.nextLine());
        System.out.print("Enter the url where you found it: ");
        var url = console.nextLine();

        var newSong = new Song(title, artist, album, genre, year, url);

        var added = songDAO.addSong(newSong);

        if (added)
            System.out.print("""

                    Song added successfully!
                    """);
        else
            System.out.print("""

                    Song not added successfully
                    """);

    }

    private static void updateSong(ISongDAO songDAO, Scanner console) {
        System.out.print("Please, tell me the id of the song you want to update :) : ");
        int id = Integer.parseInt(console.nextLine());

        var searchSong = new Song(id);

        var found = songDAO.searchSongbyId(searchSong);

        if (found) {
            System.out.println("Song found:\n" + searchSong);

            textCustom("NOTE: Any data that you don't want to change, type it as it is currently :D", 1, 1, '*', '*');
            System.out.print("Enter the title: ");
            var title = console.nextLine();
            System.out.print("Enter the artist: ");
            var artist = console.nextLine();
            System.out.print("Enter the album: ");
            var album = console.nextLine();
            System.out.print("Enter the genre: ");
            var genre = console.nextLine();
            System.out.print("Enter the year: ");
            var year = Integer.parseInt(console.nextLine());
            System.out.print("Enter the url where you found it: ");
            var url = console.nextLine();

            var updateSong = new Song(id, title, artist, album, genre, year, url);

            var updated = songDAO.updateSong(updateSong);

            if (updated)
                System.out.printf("""
                    
                    Song with ID %d was updated!
                    """, updateSong.getId());
            else
                System.out.printf("""

                    Song with ID %d was not updated
                    """, updateSong.getId());
        }

        else
            System.out.println("Song not found with id: " + searchSong.getId());
    }

    private static void deleteSong(ISongDAO songDAO, Scanner console) {
        System.out.print("Please, tell the id of the song you want to delete :( : ");
        int id = Integer.parseInt(console.nextLine());

        var searchSong = new Song(id);
        var found = songDAO.searchSongbyId(searchSong);

        if (found) {
            System.out.println("Song found:\n" + searchSong);

            var deleteSong = new Song(id);

            System.out.print("Are you sure you want to delete this song D:? (y/n): ");
            var decision = console.nextLine();

            if (decision.equals("y")) {
                var deleted = songDAO.deleteSong(deleteSong);

                if (deleted)
                    System.out.printf("""

                    Song with ID %d was deleted!

                    """, deleteSong.getId());
                else
                    System.out.printf("""

                    Song with ID %d was not deleted

                    """, deleteSong.getId());
            }
            else
                System.out.printf("""

                    Song with ID %d was not deleted
                    """, deleteSong.getId());

        }
        else
            System.out.println("Song not found with id: " + searchSong.getId());
    }
}
