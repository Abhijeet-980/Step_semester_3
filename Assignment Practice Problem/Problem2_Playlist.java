public class Problem2_Playlist {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("First song before hack: " + copy[0]);

        copy[0] = "Hacked";
        System.out.println("First song after hack: " + p.getSongs()[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}

class Playlist {
    private final String[] songs;
    private int count;

    Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.count = 0;
    }

    void addSong(String title) {
        if (count >= songs.length) {
            System.out.println("Rejected: playlist is full");
            return;
        }
        songs[count] = title;
        count++;
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
}
