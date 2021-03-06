import java.util.ArrayList;

public class Teacher {

	private String first;
	private String last;
	private boolean available;
	private ArrayList<String> classes; // can teach
	private int prepPeriod; // period they don't teach
	private int maximum; // number of students
	private int minimum;
	private int period = 0;
	private ArrayList<Class> actualClasses = new ArrayList<Class>(); //is teaching
	private ArrayList<Student> leftOver = new ArrayList<Student>();
	
	public Teacher(String first, String last, ArrayList<String> classes, String prepPeriod, String min, String max) {
		this.first = first;
		this.last = last;
		this.classes = classes;
		this.prepPeriod = Integer.parseInt(prepPeriod);
		this.maximum = Integer.parseInt(max);
		this.minimum = Integer.parseInt(min);
	}
	
	public ArrayList<String> getClasses(){
		return classes;
	}
	
	public ArrayList<Class> getActualClasses(){
		return actualClasses;
	}
	
	public int getPrepPeriod() {
		
		return prepPeriod;
	}
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	//Andie's
	public void classInitializer(String subject) {
		if(period == prepPeriod) {
			actualClasses.add(new Class("prep", period, 0,0));
			actualClasses.get(period).setAvailable(false);
			period++;
		}
		actualClasses.add(new Class(subject, period, maximum, minimum));
		period += 1;
		if (period == 7) 
			setAvailable(false);
	
	}
	/*
	 * Ham's
	public void classInitializer(String subject) {
		boolean wasprep = false;
		if(period == prepPeriod) {
			actualClasses.add(new Class("prep", period, 0, 0));
			actualClasses.get(period).setAvailable(false);
			period++;
			wasprep = true;
		}
		if(!wasprep)
			period++;
		if(period == 7)
			System.out.println("No more classes");
		else {
			
			actuaslClasses.add(new Class(subject, period, maximum, minimum));
		}

		if(leftOver.size() > 0)
			addStudent(leftOver.remove(0));
		
	}
	*/
	public void addStudent(Student stu, String choice) {
		for(Class actualClass: actualClasses)
			if(actualClass.getSubject().equals(choice)) {
				actualClass.adding(stu);
				stu.addToSchedule(this, actualClass, period);
			}
			
	}
	
	public String toString() {
		return "Teacher: " + first + " " + last;
	}
	
	
	
}
