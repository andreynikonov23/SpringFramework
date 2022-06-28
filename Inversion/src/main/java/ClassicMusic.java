
public class ClassicMusic implements Music{
	public String getSong() {
		return "Howard Shore - The Journey of Grey Country";
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
