import java.util.ArrayList;

public class MusicArray {
	private ArrayList<Music> musics = new ArrayList<>(10);
	
	MusicArray() {
		musics.add(new Pop("1"));
		musics.add(new Pop("2"));
		musics.add(new Pop("3"));
		musics.add(new Pop("4"));
		musics.add(new Pop("5"));
		musics.add(new Rock("6"));
		musics.add(new Rock("7"));
		musics.add(new Rock("8"));
		musics.add(new Rock("9"));
		musics.add(new Rock("10"));
	}
	
	public ArrayList<Music> getMusics() {	
		return musics;
	}

}
