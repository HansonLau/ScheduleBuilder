import java.util.ArrayList;
public class Student {
	private String first;
	private String last;
	private ArrayList<Subject> choices;
	private int grade;
	
	public Student(String first, String last, String grade) {
		this.first = first;
		this.last = last;
		this.grade = Integer.parseInt(grade);
	}
	
	public String toString() {
		return "Name: " + first + " " + last + "\nGrade: " + grade;
	}
}
