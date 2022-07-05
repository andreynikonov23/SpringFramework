package nick.pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:file.properties")
public class SpringConfig {
	@Bean
	public ClassicMusic classicMusic() {
		return new ClassicMusic();
	}
	@Bean
	public RockMusic rockMusic() {
		return new RockMusic();
	}
	@Bean
	public RapMusic rapMusic() {
		return new RapMusic();
	}
	@Bean
	public List<Music> musicList(){
		List<Music> music = new ArrayList<Music>();
		music.add(classicMusic());
		music.add(rockMusic());
		music.add(rapMusic());
		return music;
	}
	@Bean
	@Scope ("prototype")
	public MusicPlayer musicPlayer() {
		return new MusicPlayer(musicList());
	}
}
