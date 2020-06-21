import java.util.ArrayList;

public class Student {
	private String first;
	private String last;
	private ArrayList<String> choices;
	private int grade, start, end; //grade they are in, start period, end period
	private ArrayList<String> schedule = new ArrayList<String>();
	
	public Student(String first, String last, String grade, ArrayList<String> choices, String start, String end) {
		this.first = first;
		this.last = last;
		this.grade = Integer.parseInt(grade);
		this.choices = choices;
		this.start = Integer.parseInt(start);
		this.end = Integer.parseInt(end);
	}
	
	public int getGrade() {
		return grade;
	}
	
	public ArrayList<String> getChoices(){
		return choices;
	}
	
	public ArrayList<String> getSchedule(){
		return schedule;
	}
	
	public void addToSchedule(Teacher t, Class c, int p) {
		
		schedule.add("Period " + p + " " + c + " " + t + "\n");
		
	}
	
	public String toString() {
		return "Name: " + first + " " + last + "\nGrade: " + grade
			+ "\nSchedule: \n" + schedule;
	}

}
