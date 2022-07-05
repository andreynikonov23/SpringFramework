package nick.pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ClassicMusic implements Music {
	private List<String> musicList;
	
	
	{
		musicList = new ArrayList<>();
		musicList.add("Howard Shore - The Journey of Grey Country");
		musicList.add("Thomas Newman - Coffey on the Mile");
		musicList.add("Hans Zimmer - Stay");
	}
	
	
	public String getSong() {
		int index = (int) (Math.random() *((2 - 0) + 1))+0;
		return musicList.get(index);
	}
	
	public void initialize() {
		System.out.println("This is init-method");
	}
	public void destroy() {
		System.out.println("This is destroy-method");
	}
	@Override
	public String toString() {
		return getSong();
	}
}
