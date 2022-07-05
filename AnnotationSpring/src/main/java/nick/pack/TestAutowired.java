package nick.pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestAutowired {
	private RockMusic rockMusic;
	
	@Autowired
	public TestAutowired(RockMusic rockMusic) {
		this.rockMusic = rockMusic;
	}
	
	@Override
	public String toString() {
		return "Playing: " + rockMusic.getSong();
	}
}
