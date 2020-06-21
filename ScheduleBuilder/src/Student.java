import java.util.ArrayList;

public class Student {
	private String first;
	private String last;
	private ArrayList<String> choices;
	private int grade, start, end; //grade they are in, start period, end period
	
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
	
	public String toString() {
		return "Name: " + first + " " + last + "\nGrade: " + grade;
	}
}
