package nick.pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {
	private List<String> musicList;
	
	{
		musicList = new ArrayList<>();
		musicList.add("Motley Crue - Kickstart My Heart");
		musicList.add("Metallica - Send But True");
		musicList.add("Ozzy Osbourne - Hellraiser");
	}
	
	
	public String getSong() {
		int index = (int) (Math.random() *((2 - 0) + 1))+0;
		return musicList.get(index);
	}
	
	@Override
	public String toString() {
		return getSong();
	}
}
