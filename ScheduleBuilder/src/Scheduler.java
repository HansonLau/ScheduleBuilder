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
		for(int i = 1; i < students.size(); i++) {  //insertion sort by grade
			Student stu = students.get(i), left = students.get(i-1); 
			if(stu.getGrade() < left.getGrade() && i != 0) {
				Student temp = stu;
				students.set(i, left);
				students.set(i, temp);
				i--;
			}
			
		}
	}
	
	
}
