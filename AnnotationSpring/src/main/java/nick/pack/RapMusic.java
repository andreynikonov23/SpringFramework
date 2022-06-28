package nick.pack;

public class RapMusic implements Music {
	public String getSong() {
		return "Eminem - Stan";
	}
	
	@Override
	public String toString() {
		return getSong();
	}
}
