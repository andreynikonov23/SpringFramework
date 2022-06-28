package nick.pack;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")){
			Music music = context.getBean("classicMusic", ClassicMusic.class);
			MusicPlayer player = new MusicPlayer(music);
			player.play();
		}
	}
}
