import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class Song {
    private String name;
    private String artist;
    private String album;
    private int duration;

    public Song(String name, String artist, String album, int duration) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Song: " + name + ", Artist: " + artist + ", Album: " + album + ", Duration: " + duration + "s";
    }
}

class Playlist {
    private String name;
    private List<Song> songs;
    private Logger logger;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
        this.logger = Logger.getLogger(Playlist.class.getName());
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song) {
        songs.add(song);
        logger.log(Level.INFO, "Added song \"" + song.getName() + "\" to the playlist \"" + name + "\"");
    }

    public void removeSong(Song song) {
        songs.remove(song);
        logger.log(Level.INFO, "Removed song \"" + song.getName() + "\" from the playlist \"" + name + "\"");
    }

    public void play() {
        logger.log(Level.INFO, "Playing playlist \"" + name + "\":");
        for (Song song : songs) {
            logger.log(Level.INFO, song.toString());
        }
    }
}
public class MusicPlaylistService {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("My Playlist");

        Song song1 = new Song("Song 1", "Artist 1", "Album 1", 180);
        Song song2 = new Song("Song 2", "Artist 2", "Album 2", 240);
        Song song3 = new Song("Song 3", "Artist 3", "Album 3", 210);

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        playlist.play();

        playlist.removeSong(song2);

        playlist.play();
    }
}
