
public class RockMusic implements Music {
	
	public String getSong() {
		return "Motley Crue - Kickstart My Heart";
	}
	
	@Override
	public String toString() {
		return getSong();
	}
}
