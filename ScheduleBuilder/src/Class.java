import java.util.*;


public class Class {

	private String subject;
	private int period;	
	private int capacity;
	private ArrayList <Student> students = new ArrayList<Student>();
	
	public Class(String subject, String period, String capacity) {
		
		this.subject = subject;
		this.period = Integer.parseInt(period);
		this.capacity = Integer.parseInt(capacity);
		//students = null;
	}
	
	
}
