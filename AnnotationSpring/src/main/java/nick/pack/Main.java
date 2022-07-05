package nick.pack;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")){
			MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
			player.play(Genres.CLASSICAL);
			player.play(Genres.ROCK);
		}
	}
}
