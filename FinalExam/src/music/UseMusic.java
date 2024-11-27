import java.util.ArrayList;

public class UseMusic {

    private static MusicArray musicArray;

    public static void main(String[] args) {
        musicArray = new MusicArray();
        ArrayList<Music> musics = musicArray.getMusics();

        for (Music music : musics) {
            if (music instanceof Pop) {
                System.out.println("Genre: Pop, Title: " + music.getTitle() + ", Price: " + music.getPrice());
            }

            if (music instanceof Rock) {
                System.out.println("Genre: Rock, Title: " + music.getTitle() + ", Price: " + music.getPrice());
            }
        }
    }
}