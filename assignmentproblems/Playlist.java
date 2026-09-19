package assignmentproblems;

public class Playlist {

    private String[] songs;
    private int count;

    Playlist(int maxSongs) {
        songs = new String[maxSongs];
        count = 0;
    }

    void addSong(String song) {

        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    String[] getSongs() {

        String[] copy = new String[count];

        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    int getSongCount() {
        return count;
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        copy[0] = "Hacked";

        String[] originalView = p.getSongs();

        System.out.println(originalView[0]);
        System.out.println(p.getSongCount());
    }
}