package session_7.assignment_problems;

import java.util.Arrays;

public class M2_Playlist {

    static class Playlist {

        private final String[] songs;
        private int songCount;

        // Constructor
        Playlist(int maxSongs) {
            songs = new String[maxSongs];
            songCount = 0;
        }

        // Add song
        void addSong(String song) {

            if (songCount >= songs.length) {
                System.out.println("Playlist is full");
                return;
            }

            songs[songCount] = song;
            songCount++;
        }

        // Return a safe copy
        String[] getSongs() {

            return Arrays.copyOf(songs, songCount);
        }

        // Read-only count
        int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println(
            "Original songs: " +
            Arrays.toString(p.getSongs())
        );

        // Modify the returned copy
        copy[0] = "Hacked";

        System.out.println(
            "Modified copy: " +
            Arrays.toString(copy)
        );

        System.out.println(
            "Playlist songs: " +
            Arrays.toString(p.getSongs())
        );

        System.out.println(
            "Song count: " + p.getSongCount()
        );
    }
}