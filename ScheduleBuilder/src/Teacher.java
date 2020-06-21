import java.util.ArrayList;

public class Teacher {

	private String first;
	private String last;
	private ArrayList<String> classes;
	private int prepPeriod; // period they don't teach
	
	
	public Teacher(String first, String last, ArrayList<String> classes, String prepPeriod) {
		this.first = first;
		this.last = last;
		this.classes = classes;
		this.prepPeriod = Integer.parseInt(prepPeriod);
	}
	
	
}
