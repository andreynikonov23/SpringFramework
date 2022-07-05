package nick.pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
	private Music rockMusic;
	private Music classicMusic;
	private List<Music> musicList;
	
	@Autowired
	public MusicPlayer(@Qualifier("rockMusic") Music rockMusic, @Qualifier("classicMusic") Music classicMusic) {
		this.rockMusic = rockMusic;
		this.classicMusic = classicMusic;
	}
	public MusicPlayer(List<Music> musicList) {
		this.musicList = musicList;
	}
	public MusicPlayer() {}
	
	
	public void play(Genres genres) {
		if (genres == Genres.CLASSICAL) {
			System.out.println(classicMusic.getSong());
		}
		if (genres == Genres.ROCK) {
			System.out.println(rockMusic.getSong());
		}
	}
	public void playlist() {
		System.out.println(musicList);
	}
}
