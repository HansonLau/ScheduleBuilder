import java.util.*;

public class Subject {
	private String subject;
	private ArrayList<String> teachers = new ArrayList<String>();
	
	public Subject(String subject) {
		this.subject = subject;
		createTeacherList();
		System.out.println("test");
	}

	private void createTeacherList(){
	}
}
