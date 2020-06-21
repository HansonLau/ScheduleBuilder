import java.util.ArrayList;

public class Scheduler {
  
	private static ArrayList<Student> students = new ArrayList<Student>();
	private static ArrayList<Subject> subjects = new ArrayList<Subject>(); //may delete later
	private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();	
	
	public Scheduler(ArrayList<Student> students, ArrayList<Teacher> teachers) {
		
		this.students = students;
		this.teachers = teachers;
		sort();
		
	}
	
	//sort the students by grade, desc order
	
	public void sort() {
		for (int x = 1; x < students.size(); x++) {
			Student  current = students.get(x), left = students.get(x-1); 
			int y = x;
			while (current.getGrade() > left.getGrade() && y != 0) {
				current = students.get(y);
				left = students.get(y-1);
				Student temp = current;
				students.set(y, left);
				students.set(y-1,  temp);
				y--;
			}
		}
	}
	
	
}
