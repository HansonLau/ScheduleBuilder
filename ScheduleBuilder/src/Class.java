import java.util.*;


public class Class {

	private String subject;
	private int period;	
	private int capacity;
	private int minimum;
	private ArrayList <Student> students = new ArrayList<Student>();
	
	public Class(String subject, String period, String capacity, String minimum) {
		
		this.subject = subject;
		this.period = Integer.parseInt(period);
		this.capacity = Integer.parseInt(capacity);
		this.minimum = Integer.parseInt(minimum);
	}
	
	
}
