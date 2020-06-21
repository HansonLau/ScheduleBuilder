import java.util.ArrayList;

public class Teacher {

	private String first;
	private String last;
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
			
			actualClasses.add(new Class(subject, period, maximum, minimum));
		}

		if(leftOver.size() > 0)
			addStudent(leftOver.remove(0));
		
	}
	
	public void addStudent(Student stu) {
		/*
		if(actualClasses.size() > 0) {
			System.out.println("period: " + period);
			if(!actualClasses.get(period).getAvailable()) {
				leftOver.add(stu);
				classInitializer(actualClasses.get(period).getSubject());
			}
		}
		actualClasses.get(period).adding(stu);
		stu.addToSchedule(this, actualClasses.get(period), period);
		*/
		
		for(int i = 0; i < actualClasses.size(); i++) {
			if
		}
		
	}
	
	public String toString() {
		return "Teacher: " + first + " " + last;
	}
	
	
	
}
