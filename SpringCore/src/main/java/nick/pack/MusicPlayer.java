package nick.pack;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class MusicPlayer {
	@Value ("${player.name}")
	private String name;
	@Value ("${player.volume}")
	private int volume;
	private List<Music> musicList;
	
	
	public MusicPlayer(List<Music> musicList) {
		this.musicList = musicList;
	}
	public MusicPlayer() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public void playlist() {
		System.out.println(name + " - " + volume);
		int index = (int) (Math.random() * ((2-0) +1)+0);
		System.out.println(musicList.get(index));
	}
}
