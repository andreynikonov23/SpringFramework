package nick.pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

public class RockMusic implements Music {
		
	public String getSong() {
		return "Metallica - Sand But True";
	}
	
	@Override
	public String toString() {
		return getSong();
	}
}
