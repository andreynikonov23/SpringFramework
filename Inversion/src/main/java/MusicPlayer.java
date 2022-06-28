import java.util.List;

public class MusicPlayer {
	private Music music;
	private List<Music> musicList;
	
	
	public MusicPlayer(Music music) {
		this.music = music;
	}
	public MusicPlayer(List<Music> musicList) {
		this.musicList = musicList;
	}
	public MusicPlayer() {}
	
	
	public void play() {
		System.out.println("Играет: " + music.getSong());
	}
	public void playlist() {
		System.out.println(musicList);
	}
	
}
