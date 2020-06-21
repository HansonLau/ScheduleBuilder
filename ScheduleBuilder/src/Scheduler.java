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
	
	//scheduling with periods in mind
	
	public void schedule() {

		for(int i = 0; i < teachers.size(); i++) { // loops teachers			
			Teacher currTeacher = teachers.get(i);
			boolean found = false;
			boolean created = false;
			for(int j = 0; j < students.size(); j++) { // loops students
				Student s = students.get(j);
				for(String choice: s.getChoices()) { // loops student choices
					System.out.println(choice);
					for(int k = 0; k < currTeacher.getClasses().size(); k++) { // loops teacher classes
						System.out.println("CT " +currTeacher.getClasses().get(k));
						if(choice.equalsIgnoreCase(currTeacher.getClasses().get(k))) {
							for(int t = 0; t < s.getSchedule().size(); t++) { // checks if class is added
								if(s.getSchedule().get(t).indexOf(currTeacher.getClasses().get(k)) != -1)
									found = true;
							}
							if(found)
								break;
							for(int h = 0; h < currTeacher.getActualClasses().size(); h++) { // checks if class is already made
								
								if(choice.equalsIgnoreCase(currTeacher.getActualClasses().get(h).getSubject())) {
									if(!currTeacher.getActualClasses().get(h).getAvailable()) {
										created = false;
										break;
									}

									created = true;
									break;
								}
								if(!created)
									break;
							}
							
							if(!created) {
								System.out.println("choice: " + choice);
								currTeacher.classInitializer(choice);
								currTeacher.addStudent(s);
								System.out.println("added1 " + currTeacher.getClasses().get(k));
								created = true;
								break;
							}
							else {
								currTeacher.addStudent(s);
								System.out.println("added2 " + currTeacher.getClasses().get(k));
								break;
							}
						}
						if(found)
							break;
						
					}
				}
			}
		}
	}
	
	public void showSchedule() {
		
		for(Student s: students) {
			System.out.println(s);
		}
	}
	
}
