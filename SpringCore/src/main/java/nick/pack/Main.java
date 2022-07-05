package nick.pack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
		player.playlist();
		MusicPlayer testScope = context.getBean("musicPlayer", MusicPlayer.class);
		System.out.println(player == testScope);
	}
}
