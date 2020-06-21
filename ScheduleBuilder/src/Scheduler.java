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
		for (int x = 1; x < students.size(); x++) { //insertion sort
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
	
	public void schedule() {
		for(Student student: students) 
			for(String choice: student.getChoices()) 
				for(Teacher teacher: teachers) 
					for(String classes: teacher.getClasses()) 
						if(choice.equalsIgnoreCase(classes)) {
							Boolean create = false;
							for(Class actualClass: teacher.getActualClasses())
								if(actualClass.getSubject().equals(classes) && actualClass.getAvailable())
									create = true;
							if(!create) {
								teacher.classInitializer(choice);
								teacher.addStudent(student, choice);
							}
							else {
								teacher.addStudent(student, choice);
							}
						}
							
									
	}

	public void showSchedule() {
		
		for(Student s: students) {
			System.out.println(s);
		}
	}
	
}
