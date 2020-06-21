import java.util.ArrayList;
public class Student {
	private String first;
	private String last;
	private ArrayList<String> choices;
	private int grade;
	
	public Student(String first, String last, String grade, ArrayList<String> choices) {
		this.first = first;
		this.last = last;
		this.grade = Integer.parseInt(grade);
		this.choices = choices;
	}
	
	public String toString() {
		return "Name: " + first + " " + last + "\nGrade: " + grade;
	}
}
