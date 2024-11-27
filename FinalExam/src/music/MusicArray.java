import java.util.ArrayList;

public class MusicArray {
	private ArrayList<Music> musics = new ArrayList<>(10);
	
	MusicArray() {
		musics.add(new Pop("Kanye West"));
		musics.add(new Pop("Avicii"));
		musics.add(new Pop("Tyler the Creator"));
		musics.add(new Pop("Post Malone"));
		musics.add(new Pop("Ariana Grande"));
		musics.add(new Rock("Guns and Roses"));
		musics.add(new Rock("Twenty one Pilots"));
		musics.add(new Rock("Zack Tabudlo"));
		musics.add(new Rock("NewJeans"));
		musics.add(new Rock("Aespa"));
	}
	
	public ArrayList<Music> getMusics() {	
		return musics;
	}

}
