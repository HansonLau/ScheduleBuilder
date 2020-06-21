import java.util.*;


public class Class {

	private String subject;
	private int period;	
	private int capacity;
	private int minimum;
	private ArrayList <Student> students = new ArrayList<Student>();
	private boolean available = true;
	
	public Class(String subject, int period, int capacity, int minimum) {
		
		this.subject = subject;
		this.period = period;
		this.capacity = capacity;
		this.minimum = minimum;
	}
	
	public ArrayList<Student> getStudents(){
		
		return students;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setAvailable(boolean availability) {
		available = availability;
		if(students.size() == capacity)
			available = false;
	}
	
	public boolean getAvailable() {
		
		return available;
	}
	
	public void adding(Student stu) {
		
		students.add(stu);
		
	}
	
	public String toString() {
		return subject;
	}
	
	
}
