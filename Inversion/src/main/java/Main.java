import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")){
//			MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
//			MusicPlayer player2 = context.getBean("musicPlayer", MusicPlayer.class);
//			player.playlist();
//			System.out.println(player == player2);
			ClassicMusic classic = context.getBean("classicMusic", ClassicMusic.class);
			System.out.println(classic.getSong());
			
		}
	}
}
